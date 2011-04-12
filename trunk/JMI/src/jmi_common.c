/*
    Copyright (C) 2009 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License version 3 as published
    by the Free Software Foundation, or optionally, under the terms of the
    Common Public License version 1.0 as published by IBM.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License, or the Common Public License, for more details.

    You should have received copies of the GNU General Public License
    and the Common Public License along with this program.  If not,
    see <http://www.gnu.org/licenses/> or
    <http://www.ibm.com/developerworks/library/os-cpl.html/> respectively.
*/

/*
 * jmi_common.c contains all functions that is possible to factor out from jmi.c
 * and jmi_cppad.c. In effect, this code can be compiled either with C or a C++
 * compiler.
 */


#include "jmi.h"

jmi_ad_var_t jmi_divide(jmi_ad_var_t num, jmi_ad_var_t den,const char msg[]) {
  if (den==0) {
    printf("%s", msg);
    printf("\n");
    return (num==0)? 0: ( (num>0)? 1.e20: -1.e20 );
  } else {
    return num/den;
  }
}

jmi_ad_var_t jmi_abs(jmi_ad_var_t v) {
	return COND_EXP_GE(v, AD_WRAP_LITERAL(0), v, -v);
}

jmi_ad_var_t jmi_min(jmi_ad_var_t x, jmi_ad_var_t y) {
	return COND_EXP_LT(x, y, x ,y);
}

jmi_ad_var_t jmi_max(jmi_ad_var_t x, jmi_ad_var_t y) {
	return COND_EXP_GT(x, y, x ,y);
}

jmi_real_t jmi_dround(jmi_real_t x) {
        return (x >= 0)? floor(x + 0.5) : floor(x - 0.5);
}

jmi_real_t jmi_dremainder(jmi_real_t x, jmi_real_t y) {
        jmi_real_t res = fmod(x,y);
        return (jmi_abs(res-y)<JMI_SMALL)? res-y : res;
}


int jmi_func_new(jmi_func_t** jmi_func, jmi_residual_func_t F, int n_eq_F, jmi_jacobian_func_t sym_dF,
		int sym_dF_n_nz, int* sym_dF_row, int* sym_dF_col,jmi_directional_der_residual_func_t cad_dir_dF,
		int cad_dF_n_nz, int* cad_dF_row, int* cad_dF_col) {

	int i;

	jmi_func_t* func = (jmi_func_t*)calloc(1,sizeof(jmi_func_t));
	*jmi_func = func;

	func->n_eq_F = n_eq_F;
	func->F = F;
	func->sym_dF = sym_dF;
	func->cad_dir_dF = cad_dir_dF;

	func->sym_dF_n_nz = sym_dF_n_nz;
	func->sym_dF_row = (int*)calloc(sym_dF_n_nz,sizeof(int));
	func->sym_dF_col = (int*)calloc(sym_dF_n_nz,sizeof(int));

	for (i=0;i<sym_dF_n_nz;i++) {
		func->sym_dF_row[i] = sym_dF_row[i];
		func->sym_dF_col[i] = sym_dF_col[i];
	}

	func->cad_dF_n_nz = cad_dF_n_nz;
	func->cad_dF_row = (int*)calloc(cad_dF_n_nz,sizeof(int));
	func->cad_dF_col = (int*)calloc(cad_dF_n_nz,sizeof(int));

	for (i=0;i<cad_dF_n_nz;i++) {
		func->cad_dF_row[i] = cad_dF_row[i];
		func->cad_dF_col[i] = cad_dF_col[i];
		/* printf("* %d %d \n",func->cad_dF_row[i], func->cad_dF_col[i]);*/
	}

	func->ad = NULL;

	return 0;
}

int jmi_func_delete(jmi_func_t *func) {
	if (func->ad!=NULL) {
		return -1;
	}
	free(func->sym_dF_row);
	free(func->sym_dF_col);
	free(func->cad_dF_row);
	free(func->cad_dF_col);
	free(func);
	return 0;
}

/* Convenience function to evaluate the Jacobian of the function contained in a
 jmi_func_t. */
int jmi_func_sym_dF(jmi_t *jmi,jmi_func_t *func, int sparsity,
		int independent_vars, int* mask, jmi_real_t* jac) {
	int i;

	if (func->sym_dF==NULL) {
		return -1;
	}
	for (i=0;i<jmi->n_z;i++) {
		(*(jmi->z))[i] = (*(jmi->z_val))[i];
	}
	func->sym_dF(jmi, sparsity, independent_vars, mask, jac);
	return 0;

}

/* Convenience function for accessing the number of non-zeros in the (symbolic)
 Jacobian. */
int jmi_func_sym_dF_n_nz(jmi_t *jmi, jmi_func_t *func, int* n_nz) {
	if (func->sym_dF==NULL) {
		*n_nz = 0;
		return -1;
	}
	*n_nz = func->sym_dF_n_nz;
	return 0;
}

/* Convenience function of accessing the non-zeros in the Jacobian */
int jmi_func_sym_dF_nz_indices(jmi_t *jmi, jmi_func_t *func, int independent_vars,
                           int *mask,int *row, int *col) {
	int i;
	int index;
	
	if (func->sym_dF==NULL) {
		return -1;
	}

/*	int col_index = 0;*/           /* Column index of the new Jacobian*/
/*	int col_index_old = 0;*/       /* Temporary variable to keep track of when to increase col_index*/
	index = 0;                 /* Index in the row/col vectors of the new Jacobian */

	/* Iterate over all non-zero indices */
	for (i=0;i<func->sym_dF_n_nz;i++) {
/*		printf("%d %d\n",i,jmi_check_Jacobian_column_index(jmi, independent_vars, mask, func->dF_col[i]-1)); */
		/* Check if this particular entry should be included */
		if (jmi_check_Jacobian_column_index(jmi, independent_vars, mask, func->sym_dF_col[i]-1) == 1 ) {
			    /* Copy indices */
				row[index] = func->sym_dF_row[i];
				col[index] = jmi_map_Jacobian_column_index(jmi,independent_vars,mask,func->sym_dF_col[i]-1) + 1;
				index++;
		}
	}

	return 0;

}

/* Convenience function for computing the dimensions of the Jacobian. */
int jmi_func_sym_dF_dim(jmi_t *jmi, jmi_func_t *func, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {
	int i;
	
	*dF_n_cols = 0;
	*dF_n_nz = 0;

	if (func->sym_dF==NULL) {
		return -1;
	}

	for (i=0;i<jmi->n_z;i++) {
		if (jmi_check_Jacobian_column_index(jmi, independent_vars, mask, i) == 1 ) {
			(*dF_n_cols)++;
		}
	}

	if (sparsity == JMI_DER_SPARSE) {
		for (i=0;i<func->sym_dF_n_nz;i++) {
/*			printf(">>>>>>>>>>>>>>>>>>\n"); */
			/* Check if this particular entry should be included */
			if (jmi_check_Jacobian_column_index(jmi, independent_vars, mask, func->sym_dF_col[i]-1) == 1 ) {
				(*dF_n_nz)++;
			}
		}
	} else {
		*dF_n_nz = *dF_n_cols*func->n_eq_F;
	}

	return 0;

}

int jmi_func_sym_directional_dF(jmi_t *jmi, jmi_func_t *func, jmi_real_t *res,
			 jmi_real_t *dF, jmi_real_t* dv) {
		return -1;	
}


int jmi_func_cad_dF(jmi_t *jmi,jmi_func_t *func, int sparsity,
		int independent_vars, int* mask, jmi_real_t* jac) {
	
	int i;
	int j;
	int k;
	int l;
	
	int dF_n_cols;
	int dF_n_nz;
	int n_colors;
	int dF_n_eq = 0;
	
	int max_columns;
	int *row_offs;
	int *dF_row;
	int *dF_col;
	int *dF_col_independent_ind;
	int *offs;
	int *sparse_repr;
	int *map_info;
	int *map_off;
	jmi_real_t *res;
	jmi_real_t *dF;
	jmi_real_t *dv;


	max_columns  = func->cad_dF_col[func->cad_dF_n_nz-1]+1;
	
	jmi_func_cad_dF_dim(jmi, func, sparsity, independent_vars, mask, &dF_n_cols, &dF_n_nz);

	row_offs = (int*)calloc(dF_n_cols, sizeof(int));
	dF_row = (int*)calloc(dF_n_nz, sizeof(int));
	dF_col = (int*)calloc(dF_n_nz, sizeof(int));
	dF_col_independent_ind = (int*)calloc(dF_n_nz,sizeof(int));
	
	jmi_func_cad_dF_nz_indices(jmi, func, independent_vars, mask, dF_row, dF_col);
	jmi_func_cad_dF_get_independent_ind(jmi, func, independent_vars, dF_col_independent_ind); 
	
	j = 0;
	for(i = 0; i < dF_n_nz; i++){
		if(dF_col[i] == j){
			row_offs[j] = i;
			j++;
		}
	}
	
	offs = (int*)calloc(dF_n_cols, sizeof(int));
	sparse_repr = (int*)calloc(dF_n_cols, sizeof(int));
	map_info = (int*)calloc(dF_n_nz, sizeof(int));
	map_off = (int*)calloc(dF_n_cols, sizeof(int));
	
	jmi_dae_cad_color_graph(jmi, func, dF_n_cols, dF_n_nz, &dF_row[0], &dF_col[0], sparse_repr, offs, &n_colors, map_info, map_off);
	
	for(i = 0; i < func->cad_dF_n_nz;i++){
		if(func->cad_dF_row[i] > dF_n_eq){
			dF_n_eq = func->cad_dF_row[i];
		}
	}
	dF_n_eq++;
	
	res = (jmi_real_t*)calloc(dF_n_eq, sizeof(jmi_real_t));
	dF = (jmi_real_t*)calloc(dF_n_eq, sizeof(jmi_real_t));
	dv = (jmi_real_t*)calloc(max_columns, sizeof(jmi_real_t));
	for(i = 0; i < max_columns;i++){
		dv[i] = 0;
	}
	for(i = 0; i < dF_n_eq;i++){
		dF[i] = 0;
		res[i] = 0;
	}
	
	if(sparsity & JMI_DER_SPARSE){
		for(i = 0; i < dF_n_nz; i++){
			jac[i] = 0;
		}
	} else if(sparsity & JMI_DER_DENSE_COL_MAJOR){
		for(i = 0; i < dF_n_eq*dF_n_cols; i++){
			jac[i] = 0;
		}
	} else if(sparsity & JMI_DER_DENSE_ROW_MAJOR){
		for(i = 0; i < dF_n_eq*dF_n_cols; i++){
			jac[i] = 0;
		}
	} else{
		return -1;
	}
	
	for(i = 0; i < n_colors; i++){
		int max_1 = 0;
		
		if(i != n_colors-1){
			max_1 = offs[i+1];
		}else{
			max_1 = dF_n_cols;
		}
		
		for(j = offs[i]; j < max_1;j++){
			dv[dF_col_independent_ind[row_offs[sparse_repr[j]]]] = 1;
		}
		jmi_func_cad_directional_dF(jmi, jmi->dae->F, res, dF, dv);
		
		for(j = offs[i]; j < max_1;j++){
			
			int max_2 = 0;	
			if(j != dF_n_cols - 1){
				max_2 = map_off[j+1];
			} else{
				max_2 = dF_n_nz;
			}
			for(k = map_off[j]; k < max_2; k++){
				int this_column = sparse_repr[j];
				int this_row = map_info[k];
				jmi_real_t this_value = dF[map_info[k]];
				if(sparsity & JMI_DER_SPARSE){
					l = row_offs[this_column];
					while(dF_row[l] != this_row){
						l++;
					}
					jac[l] = this_value;
				} else if(sparsity & JMI_DER_DENSE_COL_MAJOR){
					jac[dF_n_eq*this_column+this_row] = this_value;
				} else if(sparsity & JMI_DER_DENSE_ROW_MAJOR){
					jac[dF_n_cols*this_row+this_column] = this_value;
				} else{
					return -1;
				}
			}
		}
		for(j = offs[i]; j < max_1;j++){
			dv[dF_col_independent_ind[row_offs[sparse_repr[j]]]] = 0;
		}
	}
	
	free(map_off);
	free(map_info);
	free(sparse_repr);
	free(offs);
	free(res);
	free(dF);
	free(dv);
	free(row_offs);
	free(dF_row);
	free(dF_col);
	free(dF_col_independent_ind);
	return 0;
}


int jmi_func_cad_dF_n_nz(jmi_t *jmi, jmi_func_t *func, int* n_nz) {
	*n_nz = func->cad_dF_n_nz;
	return 0;
}

int jmi_func_cad_dF_nz_indices(jmi_t *jmi, jmi_func_t *func, int independent_vars,
                           int *mask,int *row, int *col) {
	
	int n_p_opt = jmi->opt->n_p_opt;
	int n_dx = jmi->n_real_dx;
	int n_x = jmi->n_real_x;
	int n_u = jmi->n_real_u;
	int n_w = jmi->n_real_w;
	int n_t = 0;

	int max_n_nz = func->cad_dF_n_nz;
	
	int aim = 0;
	int offs = 0;
	int i = 0;
	int j = 0;
	
	i = 0;

	if(JMI_DER_T & independent_vars){
		n_t = 1;
	}
	
	aim+=n_p_opt;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_P_OPT & independent_vars){	
			col[j] = func->cad_dF_col[i]-offs;
			row[j] = func->cad_dF_row[i];
			j++;
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]+1<func->cad_dF_col[i+1]){
					offs+=func->cad_dF_col[i+1]-(func->cad_dF_col[i]+1);
				}
			}
		}
		i++;
	}
	if(!(JMI_DER_P_OPT & independent_vars)){	
		offs+=n_p_opt;
		
	}

	aim+=n_dx;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_DX & independent_vars){	
			col[j] = func->cad_dF_col[i]-offs;
			row[j] = func->cad_dF_row[i];
			j++;
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]+1<func->cad_dF_col[i+1]){
					offs+=func->cad_dF_col[i+1]-(func->cad_dF_col[i]+1);
				}
			}
		}
		i++;
	}
	if(!(JMI_DER_DX & independent_vars)){	
		offs+=n_dx;
	}
	
	aim+=n_x;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_X & independent_vars){
			col[j] = func->cad_dF_col[i]-offs;
			row[j] = func->cad_dF_row[i];
			j++;
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]+1<func->cad_dF_col[i+1]){
					offs+=func->cad_dF_col[i+1]-(func->cad_dF_col[i]+1);
				}
			}
		}
		i++;
	}
	if(!(JMI_DER_X & independent_vars)){	
		offs+=n_x;
	}
	
	aim+=n_u;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_U & independent_vars){
			col[j] = func->cad_dF_col[i]-offs;
			row[j] = func->cad_dF_row[i];
			j++;
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]+1<func->cad_dF_col[i+1]){
					offs+=func->cad_dF_col[i+1]-(func->cad_dF_col[i]+1);
				}
			}
		}
		i++;
	}
	if(!(JMI_DER_U & independent_vars)){	
		offs+=n_u;
	}
	
	aim+=n_w;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_W & independent_vars){	
			col[j] = func->cad_dF_col[i]-offs;
			row[j] = func->cad_dF_row[i];
			j++;		
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]+1<func->cad_dF_col[i+1]){
					offs+=func->cad_dF_col[i+1]-(func->cad_dF_col[i]+1);
				}
			}
		}
		i++;
	}
	if(!(JMI_DER_W & independent_vars)){	
		offs+=n_w;
	}
	
	aim+=n_t;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_T & independent_vars){	
			col[j] = func->cad_dF_col[i]-offs;
			row[j] = func->cad_dF_row[i];
			j++;		
		}
		i++;
	}
	return 0;
}

int jmi_func_cad_dF_dim(jmi_t *jmi, jmi_func_t *func, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {
	
	int n_p_opt = jmi->opt->n_p_opt;
	int n_dx = jmi->n_real_dx;
	int n_x = jmi->n_real_x;
	int n_u = jmi->n_real_u;
	int n_w = jmi->n_real_w;
	int n_t = 0;

	int n_cols = 0;
	
	int max_n_nz = func->cad_dF_n_nz;
	
	int aim = 0;
	int i = 0;
	int j = 0;

	if(JMI_DER_T & independent_vars){
		n_t = 1;
	}
	
	aim+=n_p_opt;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_P_OPT & independent_vars){	
			j++;
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
					n_cols++;
				}
			} else{
				n_cols++;
			}
		}
		i++;
	}
	aim+=n_dx;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_DX & independent_vars){	
			j++;
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
					n_cols++;
				}
			} else{
				n_cols++;
			}
		}
		i++;
	}
	aim+=n_x;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_X & independent_vars){
			j++;
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
					n_cols++;
				}
			} else{
				n_cols++;
			}
		}
		i++;
	}
	aim+=n_u;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_U & independent_vars){
			j++;
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
					n_cols++;
				}
			} else{
				n_cols++;
			}
		}
		i++;
	}
	aim+=n_w;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_W & independent_vars){	
			j++;
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
					n_cols++;
				}
			} else{
				n_cols++;
			}	
		}
		i++;
	}
	aim+=n_t;
	while(func->cad_dF_col[i]<aim && aim != 0 && i < max_n_nz){
		if(JMI_DER_T & independent_vars){	
			j++;
			if(i != max_n_nz-1){
				if(func->cad_dF_col[i]<func->cad_dF_col[i+1]){
					n_cols++;
				}
			} else{
				n_cols++;
			}		
		}
		i++;
	}
	
	*dF_n_cols = n_cols;
	*dF_n_nz = j;
	return 0;
}

int jmi_func_fd_dF(jmi_t *jmi,jmi_func_t *func, int sparsity,
		int independent_vars, int* mask, jmi_real_t* jac) {
	int i;
	int j;
	int k;
	
	int dF_n_cols;
	int dF_n_nz;
	int dF_n_eq = 0;
	int max_columns = func->cad_dF_col[func->cad_dF_n_nz-1]+1;
	
	
	int *row_offs = (int*)calloc(dF_n_cols, sizeof(int));
	int *dF_row = (int*)calloc(dF_n_nz, sizeof(int));
	int *dF_col = (int*)calloc(dF_n_nz, sizeof(int));
	int *dF_col_independent_ind = (int*)calloc(dF_n_nz,sizeof(int));

	jmi_real_t *res;
	jmi_real_t *dF;
	jmi_real_t *dv;

	jmi_func_cad_dF_dim(jmi, func, sparsity, independent_vars, mask, &dF_n_cols, &dF_n_nz);	
	jmi_func_cad_dF_nz_indices(jmi, func, independent_vars, mask, dF_row, dF_col);
	jmi_func_cad_dF_get_independent_ind(jmi, func, independent_vars, dF_col_independent_ind); 
	j = 0;
	for(i = 0; i < dF_n_nz; i++){
		if(dF_col[i] == j){
			row_offs[j] = i;
			j++;
		}
	}
	for(i = 0; i < func->cad_dF_n_nz;i++){
		if(func->cad_dF_row[i] > dF_n_eq){
			dF_n_eq = func->cad_dF_row[i];
		}
	}
	dF_n_eq++;
	
	res = (jmi_real_t*)calloc(dF_n_eq, sizeof(jmi_real_t));
	dF = (jmi_real_t*)calloc(dF_n_eq, sizeof(jmi_real_t));
	dv = (jmi_real_t*)calloc(max_columns, sizeof(jmi_real_t));
	for(i = 0; i < max_columns;i++){
		dv[i] = 0;
	}
	
	if(sparsity & JMI_DER_SPARSE){
		for(i = 0; i < dF_n_nz; i++){
			jac[i] = 0;
		}
	} else if(sparsity & JMI_DER_DENSE_COL_MAJOR){
		for(i = 0; i < dF_n_eq*dF_n_cols; i++){
			jac[i] = 0;
		}
	} else if(sparsity & JMI_DER_DENSE_ROW_MAJOR){
		for(i = 0; i < dF_n_eq*dF_n_cols; i++){
			jac[i] = 0;
		}
	} else{
		return -1;
	}
	
	for(i = 0; i < dF_n_cols; i++){
		dv[dF_col_independent_ind[row_offs[i]]] = 1.0;
		jmi_func_fd_directional_dF(jmi, func, res, dF, dv); 
		for(j = 0; j < dF_n_eq; j++){
			int this_column = i;
			int this_row = j;
			jmi_real_t this_value = dF[j];
				
			if(sparsity & JMI_DER_SPARSE){
				if(this_value != 0){
					k = row_offs[this_column];
					while(dF_row[k] != this_row){
						k++;
					}
					jac[k] = this_value;
				}
			} else if(sparsity & JMI_DER_DENSE_COL_MAJOR){
				jac[dF_n_eq*this_column+this_row] = this_value;
			} else if(sparsity & JMI_DER_DENSE_ROW_MAJOR){
				jac[dF_n_cols*this_row+this_column] = this_value;
			} else{
				return -1;
			}
		}	
		dv[dF_col_independent_ind[row_offs[i]]] = 0;
	}
	free(res);
	free(dF);
	free(dv);
	free(row_offs);
	free(dF_row);
	free(dF_col);
	free(dF_col_independent_ind);
	return 0;
}

int jmi_func_fd_dF_n_nz(jmi_t *jmi, jmi_func_t *func, int* n_nz) {
	*n_nz = func->cad_dF_n_nz;
	return 0;
}

int jmi_func_fd_dF_nz_indices(jmi_t *jmi, jmi_func_t *func, int independent_vars,
                           int *mask,int *row, int *col) {
	jmi_func_cad_dF_nz_indices(jmi, func, independent_vars, mask, row, col);
	return 0;
}

int jmi_func_fd_dF_dim(jmi_t *jmi, jmi_func_t *func, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {
	jmi_func_cad_dF_dim(jmi, func, sparsity, independent_vars, mask, dF_n_cols, dF_n_nz);
	return 0;
}

int jmi_func_fd_directional_dF(jmi_t *jmi, jmi_func_t *func, jmi_real_t *res,
			 jmi_real_t *dF, jmi_real_t* dv) {
	jmi_dae_directional_FD_dF(jmi, func, res, dF, dv);
	return 0;
}


int jmi_get_sizes(jmi_t* jmi, int* n_real_ci, int* n_real_cd, int* n_real_pi, int* n_real_pd,
		int* n_integer_ci, int* n_integer_cd, int* n_integer_pi, int* n_integer_pd,
		int* n_boolean_ci, int* n_boolean_cd, int* n_boolean_pi, int* n_boolean_pd,
		int* n_real_dx, int* n_real_x, int* n_real_u, int* n_real_w,int* n_tp,
		int* n_real_d, int* n_integer_d, int* n_integer_u, int* n_boolean_d, int* n_boolean_u,
		int* n_sw, int* n_sw_init, int* n_guards, int* n_guards_init, int* n_z) {

	*n_real_ci = jmi->n_real_ci;
	*n_real_cd = jmi->n_real_cd;
	*n_real_pi = jmi->n_real_pi;
	*n_real_pd = jmi->n_real_pd;

	*n_integer_ci = jmi->n_integer_ci;
	*n_integer_cd = jmi->n_integer_cd;
	*n_integer_pi = jmi->n_integer_pi;
	*n_integer_pd = jmi->n_integer_pd;

	*n_boolean_ci = jmi->n_boolean_ci;
	*n_boolean_cd = jmi->n_boolean_cd;
	*n_boolean_pi = jmi->n_boolean_pi;
	*n_boolean_pd = jmi->n_boolean_pd;

	*n_real_dx = jmi->n_real_dx;
	*n_real_x = jmi->n_real_x;
	*n_real_u = jmi->n_real_u;
	*n_real_w = jmi->n_real_w;
	*n_tp = jmi->n_tp;
	*n_real_d = jmi->n_real_d;
	*n_integer_d = jmi->n_integer_d;
	*n_integer_u = jmi->n_integer_u;
	*n_boolean_d = jmi->n_boolean_d;
	*n_boolean_u = jmi->n_boolean_u;

    *n_sw = jmi->n_sw;
    *n_sw_init = jmi->n_sw_init;
    *n_guards = jmi->n_guards;
    *n_guards_init = jmi->n_guards_init;

    *n_z = jmi->n_z;

	return 0;
}

int jmi_get_offsets(jmi_t* jmi, int* offs_real_ci, int* offs_real_cd,
		int* offs_real_pi, int* offs_real_pd,
		int* offs_integer_ci, int* offs_integer_cd,
		int* offs_integer_pi, int* offs_integer_pd,
		int* offs_boolean_ci, int* offs_boolean_cd,
		int* offs_boolean_pi, int* offs_boolean_pd,
		int* offs_real_dx, int* offs_real_x, int* offs_real_u,
		int* offs_real_w, int *offs_t,
		int* offs_real_dx_p, int* offs_real_x_p,
		int* offs_real_u_p, int* offs_real_w_p,
		int* offs_real_d, int* offs_integer_d, int* offs_integer_u,
		int* offs_boolean_d, int* offs_boolean_u,
		int* offs_sw, int* offs_sw_init,
		int* offs_guards, int* offs_guards_init,
		int* offs_pre_real_dx, int* offs_pre_real_x, int* offs_pre_real_u,
		int* offs_pre_real_w,
		int* offs_pre_real_d, int* offs_pre_integer_d, int* offs_pre_integer_u,
		int* offs_pre_boolean_d, int* offs_pre_boolean_u,
		int* offs_pre_sw, int* offs_pre_sw_init,
		int* offs_pre_guards, int* offs_pre_guards_init) {

	*offs_real_ci = jmi->offs_real_ci;
	*offs_real_cd = jmi->offs_real_cd;
	*offs_real_pi = jmi->offs_real_pi;
	*offs_real_pd = jmi->offs_real_pd;

	*offs_integer_ci = jmi->offs_integer_ci;
	*offs_integer_cd = jmi->offs_integer_cd;
	*offs_integer_pi = jmi->offs_integer_pi;
	*offs_integer_pd = jmi->offs_integer_pd;

	*offs_boolean_ci = jmi->offs_boolean_ci;
	*offs_boolean_cd = jmi->offs_boolean_cd;
	*offs_boolean_pi = jmi->offs_boolean_pi;
	*offs_boolean_pd = jmi->offs_boolean_pd;

	*offs_real_dx = jmi->offs_real_dx;
	*offs_real_x = jmi->offs_real_x;
	*offs_real_u = jmi->offs_real_u;
	*offs_real_w = jmi->offs_real_w;
	*offs_t = jmi->offs_t;
	*offs_real_dx_p = jmi->offs_real_dx_p;
	*offs_real_x_p = jmi->offs_real_x_p;
	*offs_real_u_p = jmi->offs_real_u_p;
	*offs_real_w_p = jmi->offs_real_w_p;

	*offs_real_d = jmi->offs_real_d;

	*offs_integer_d = jmi->offs_integer_d;
	*offs_integer_u = jmi->offs_integer_u;

	*offs_boolean_d = jmi->offs_boolean_d;
	*offs_boolean_u = jmi->offs_boolean_u;

	*offs_sw = jmi->offs_sw;
	*offs_sw_init = jmi->offs_sw_init;

	*offs_guards = jmi->offs_guards;
	*offs_guards_init = jmi->offs_guards_init;

	*offs_pre_real_dx = jmi->offs_pre_real_dx;
	*offs_pre_real_x = jmi->offs_pre_real_x;
	*offs_pre_real_u = jmi->offs_pre_real_u;
	*offs_pre_real_w = jmi->offs_pre_real_w;

	*offs_pre_real_d = jmi->offs_pre_real_d;

	*offs_pre_integer_d = jmi->offs_pre_integer_d;
	*offs_pre_integer_u = jmi->offs_pre_integer_u;

	*offs_pre_boolean_d = jmi->offs_pre_boolean_d;
	*offs_pre_boolean_u = jmi->offs_pre_boolean_u;

	*offs_pre_sw = jmi->offs_pre_sw;
	*offs_pre_sw_init = jmi->offs_pre_sw_init;

	*offs_pre_guards = jmi->offs_pre_guards;
	*offs_pre_guards_init = jmi->offs_pre_guards_init;

	return 0;
}

int jmi_copy_pre_values(jmi_t *jmi) {
	int i;
	jmi_real_t* z;
	z = jmi_get_z(jmi);
	for (i=jmi->offs_real_dx;i<jmi->offs_t;i++) {
		z[i - jmi->offs_real_dx + jmi->offs_pre_real_dx] = z[i];
	}
	for (i=jmi->offs_real_d;i<jmi->offs_pre_real_dx;i++) {
		z[i - jmi->offs_real_d + jmi->offs_pre_real_d] = z[i];
	}
	return 0;
}

int jmi_dae_init(jmi_t* jmi,
		jmi_residual_func_t F, int n_eq_F, jmi_jacobian_func_t sym_dF,
		int sym_dF_n_nz, int* sym_dF_row, int* sym_dF_col,
		jmi_directional_der_residual_func_t cad_dir_dF,
		int cad_dF_n_nz, int* cad_dF_row, int* cad_dF_col,
		jmi_residual_func_t R, int n_eq_R, jmi_jacobian_func_t dR,
		int dR_n_nz, int* dR_row, int* dR_col,
        jmi_generic_func_t ode_derivatives,
        jmi_generic_func_t ode_outputs,
        jmi_generic_func_t ode_initialize,
        jmi_generic_func_t ode_guards,
        jmi_generic_func_t ode_guards_init,
        jmi_next_time_event_func_t ode_next_time_event) {

	jmi_func_t* jf_F;
	jmi_func_t* jf_R;
	
	/* Create jmi_dae struct */
	jmi_dae_t* dae = (jmi_dae_t*)calloc(1,sizeof(jmi_dae_t));
	jmi->dae = dae;

	jmi_func_new(&jf_F,F,n_eq_F,sym_dF,sym_dF_n_nz,sym_dF_row, sym_dF_col,cad_dir_dF,
			cad_dF_n_nz, cad_dF_row, cad_dF_col);

	jmi->dae->F = jf_F;

	jmi_func_new(&jf_R,R,n_eq_R,dR,dR_n_nz,dR_row, dR_col,NULL, 0, NULL, NULL);
	jmi->dae->R = jf_R;

	jmi->dae->ode_derivatives = ode_derivatives;
	jmi->dae->ode_outputs = ode_outputs;
	jmi->dae->ode_initialize = ode_initialize;
    jmi->dae->ode_guards = ode_guards;
    jmi->dae->ode_guards_init = ode_guards_init;
    jmi->dae->ode_next_time_event = ode_next_time_event;
	return 0;
}

int jmi_info_init(jmi_t* jmi, fmiString instance_name, fmiString guid, fmiBoolean logging_on){
	fmiBoolean* tmpguid;
	fmiBoolean* tmpname;
	size_t name_len;
	size_t guid_len;
	
	/* Create jmi_info struct */
	jmi_info_t* info = (jmi_info_t*)calloc(1,sizeof(jmi_info_t));
	jmi->info = info;
	
	/* Copy guid */
	guid_len = strlen(guid)+1;
    tmpguid = (fmiBoolean*)calloc(guid_len, sizeof(fmiBoolean));
    strncpy(tmpguid, guid, guid_len);
    jmi->info->guid = tmpguid;
	
	/* Copy instance name */
	name_len = strlen(instance_name)+1;
    tmpname = (fmiBoolean*)calloc(name_len, sizeof(fmiBoolean));
    strncpy(tmpname, instance_name, name_len);
    jmi->info->guid = tmpname;
	
	/* Set logging */
	jmi->info->logging_on = logging_on;

	return 0;
}

int jmi_sim_init(jmi_t* jmi, fmiReal relative_tolerance){
	
	/* Create jmi_sim struct */
	jmi_sim_t* sim = (jmi_sim_t*)calloc(1, sizeof(jmi_sim_t));
	jmi->sim = sim;
	
	jmi->sim->relative_tolerance = relative_tolerance;
	jmi->sim->sfac_events = 0.0001; /* Safety factor from FMI specification. */
	jmi->sim->sfac_newton = 0.01; /* This safety factor needs more investigation. */
	jmi->sim->event_epsilon = jmi->sim->sfac_events*relative_tolerance;
	jmi->sim->newton_tolerance = jmi->sim->sfac_newton*relative_tolerance;
	
	return 0;
}

int jmi_dae_add_equation_block(jmi_t* jmi, jmi_block_residual_func_t F, int n, int index) {
	jmi_block_residual_t* b;
	int flag;
	flag = jmi_new_block_residual(&b,jmi,F,n,index);
	jmi->dae_block_residuals[index] = b;
	return 0;
}

int jmi_dae_init_add_equation_block(jmi_t* jmi, jmi_block_residual_func_t F, int n, int index) {
	jmi_block_residual_t* b;
	int flag;
	flag = jmi_new_block_residual(&b,jmi,F,n,index);
	jmi->dae_init_block_residuals[index] = b;
	return 0;
}

int jmi_new_block_residual(jmi_block_residual_t** block, jmi_t* jmi, jmi_block_residual_func_t F, int n,int index){
	jmi_block_residual_t* b = (jmi_block_residual_t*)calloc(1,sizeof(jmi_block_residual_t));
	*block = b;
	
	b->jmi = jmi;
	b->F = F;
	b->n = n;
	b->index = index ;
	b->x = (jmi_real_t*)calloc(n,sizeof(jmi_real_t));
	b->res = (jmi_real_t*)calloc(n,sizeof(jmi_real_t));
	b->jac = (jmi_real_t*)calloc(n*n,sizeof(jmi_real_t));
	b->ipiv = (int*)calloc(n,sizeof(int));
	b->init = 1;
	/*Initialize Kinsol.*/
	b->kin_mem = KINCreate();
	b->kin_y = N_VNew_Serial(n);
	b->kin_y_scale = N_VNew_Serial(n);
	b->kin_f_scale = N_VNew_Serial(n);
	b->kin_ftol = JMI_DEFAULT_KINSOL_TOL;
	b->kin_stol = JMI_DEFAULT_KINSOL_TOL;
	return 0;
}

int jmi_delete_block_residual(jmi_block_residual_t* b){
	free(b->x);
	free(b->res);
	free(b->jac);
	free(b->ipiv);
	/*Deallocate Kinsol work vectors.*/
	N_VDestroy_Serial(b->kin_y);
	N_VDestroy_Serial(b->kin_y_scale);
	N_VDestroy_Serial(b->kin_f_scale);
	/*Deallocate Kinsol */
	KINFree(&(b->kin_mem));
	/*Deallocate struct */
	free(b);
	return 0;
}

int jmi_init_init(jmi_t* jmi, jmi_residual_func_t F0, int n_eq_F0,
		jmi_jacobian_func_t dF0,
		int dF0_n_nz, int* dF0_row, int* dF0_col,
		jmi_residual_func_t F1, int n_eq_F1,
		jmi_jacobian_func_t dF1,
		int dF1_n_nz, int* dF1_row, int* dF1_col,
		jmi_residual_func_t Fp, int n_eq_Fp,
		jmi_jacobian_func_t dFp,
		int dFp_n_nz, int* dFp_row, int* dFp_col,
		jmi_generic_func_t eval_parameters,
		jmi_residual_func_t R0, int n_eq_R0,
		jmi_jacobian_func_t dR0,
		int dR0_n_nz, int* dR0_row, int* dR0_col) {
	jmi_func_t* jf_F0;
	jmi_func_t* jf_F1;
	jmi_func_t* jf_Fp;
	jmi_func_t* jf_R0;
	
	/* Create jmi_init struct */
	jmi_init_t* init = (jmi_init_t*)calloc(1,sizeof(jmi_init_t));
	jmi->init = init;

	jmi_func_new(&jf_F0,F0,n_eq_F0,dF0,dF0_n_nz,dF0_row, dF0_col, NULL, 0, NULL, NULL);
	jmi->init->F0 = jf_F0;

	jmi_func_new(&jf_F1,F1,n_eq_F1,dF1,dF1_n_nz,dF1_row, dF1_col, NULL, 0, NULL, NULL);
	jmi->init->F1 = jf_F1;

	jmi_func_new(&jf_Fp,Fp,n_eq_Fp,dFp,dFp_n_nz,dFp_row, dFp_col, NULL, 0, NULL, NULL);
	jmi->init->Fp = jf_Fp;

	jmi->init->eval_parameters = eval_parameters;

	jmi_func_new(&jf_R0,R0,n_eq_R0,dFp,dR0_n_nz,dR0_row, dR0_col, NULL, 0, NULL, NULL);
	jmi->init->R0 = jf_R0;

	return 0;
}

int jmi_opt_init(jmi_t* jmi, jmi_residual_func_t Ffdp,int n_eq_Fdp,
		 jmi_jacobian_func_t dFfdp,
		 int dFfdp_n_nz, int* dFfdp_row, int* dFfdp_col,
		 jmi_residual_func_t J, int n_eq_J, jmi_jacobian_func_t dJ,
		 int dJ_n_nz, int* dJ_row, int* dJ_col,
		 jmi_residual_func_t L, int n_eq_L, jmi_jacobian_func_t dL,
		 int dL_n_nz, int* dL_row, int* dL_col,
		jmi_residual_func_t Ceq, int n_eq_Ceq,
		jmi_jacobian_func_t dCeq,
		int dCeq_n_nz, int* dCeq_row, int* dCeq_col,
		jmi_residual_func_t Cineq, int n_eq_Cineq,
		jmi_jacobian_func_t dCineq,
		int dCineq_n_nz, int* dCineq_row, int* dCineq_col,
		jmi_residual_func_t Heq, int n_eq_Heq,
		jmi_jacobian_func_t dHeq,
		int dHeq_n_nz, int* dHeq_row, int* dHeq_col,
		jmi_residual_func_t Hineq, int n_eq_Hineq,
		jmi_jacobian_func_t dHineq,
		int dHineq_n_nz, int* dHineq_row, int* dHineq_col) {
	jmi_func_t* jf_Ffdp;
	jmi_func_t* jf_J;
	jmi_func_t* jf_L;
	jmi_func_t* jf_Ceq;
	jmi_func_t* jf_Cineq;
	jmi_func_t* jf_Heq;
	jmi_func_t* jf_Hineq;
	
	/* Create opt_init_t struct */
	jmi_opt_t* opt = (jmi_opt_t*)calloc(1,sizeof(jmi_opt_t));
	jmi->opt = opt;


	jmi_func_new(&jf_Ffdp,Ffdp,n_eq_Fdp,dFfdp,dFfdp_n_nz,dFfdp_row, dFfdp_col, NULL, 0, NULL, NULL);
	jmi->opt->Ffdp = jf_Ffdp;

	jmi_func_new(&jf_J,J,n_eq_J,dJ,dJ_n_nz,dJ_row, dJ_col, NULL, 0, NULL, NULL);
	jmi->opt->J = jf_J;

	jmi_func_new(&jf_L,L,n_eq_L,dL,dL_n_nz,dL_row, dL_col, NULL, 0, NULL, NULL);
	jmi->opt->L = jf_L;

	jmi_func_new(&jf_Ceq,Ceq,n_eq_Ceq,dCeq,dCeq_n_nz,dCeq_row, dCeq_col, NULL, 0, NULL, NULL);
	jmi->opt->Ceq = jf_Ceq;

	jmi_func_new(&jf_Cineq,Cineq,n_eq_Cineq,dCineq,dCineq_n_nz,dCineq_row, dCineq_col, NULL, 0, NULL, NULL);
	jmi->opt->Cineq = jf_Cineq;

	jmi_func_new(&jf_Heq,Heq,n_eq_Heq,dHeq,dHeq_n_nz,dHeq_row, dHeq_col, NULL, 0, NULL, NULL);
	jmi->opt->Heq = jf_Heq;

	jmi_func_new(&jf_Hineq,Hineq,n_eq_Hineq,dHineq,dHineq_n_nz,dHineq_row, dHineq_col, NULL, 0, NULL, NULL);
	jmi->opt->Hineq = jf_Hineq;

	return 0;

}

int jmi_variable_type(jmi_t *jmi, int col_index) {
	int i;

    if (col_index>=jmi->offs_real_ci && col_index<jmi->offs_real_cd) {
    	return JMI_DER_CI;
    } else if (col_index >= jmi->offs_real_cd && col_index < jmi->offs_real_pi) {
    	return JMI_DER_CD;
    } else if (col_index>=jmi->offs_real_pi && col_index<jmi->offs_real_pd) {
    	return JMI_DER_PI;
    } else if (col_index>=jmi->offs_real_pd && col_index<jmi->offs_real_dx) {
    	return JMI_DER_PD;
    } else if (col_index>=jmi->offs_real_dx && col_index<jmi->offs_real_x) {
    	return JMI_DER_DX;
    } else if (col_index>=jmi->offs_real_x && col_index<jmi->offs_real_u) {
    	return JMI_DER_X;
    } else if (col_index>=jmi->offs_real_u && col_index<jmi->offs_real_w) {
    	return JMI_DER_U;
    } else if (col_index>=jmi->offs_real_w && col_index<jmi->offs_t) {
    	return JMI_DER_W;
    } else if (col_index==jmi->offs_t) {
    	return JMI_DER_T;
    }

    for (i=0;i<jmi->n_tp;i++) {
    	if (col_index>=jmi->offs_real_dx_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i &&
    			col_index<jmi->offs_real_x_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i) {
    		return JMI_DER_DX_P;
    	} else if (col_index>=jmi->offs_real_x_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i &&
    			col_index<jmi->offs_real_u_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i) {
    		return JMI_DER_X_P;
    	} else if (col_index>=jmi->offs_real_u_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i &&
    			col_index<jmi->offs_real_w_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i) {
    		return JMI_DER_U_P;
    	} else if (col_index>=jmi->offs_real_w_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i &&
    			col_index<jmi->offs_real_w_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i + jmi->n_real_w) {
    		return JMI_DER_W_P;
    	}
    }

    return -1;
}

int jmi_check_Jacobian_column_index(jmi_t *jmi, int independent_vars, int *mask, int col_index) {

	/*printf("%d\n",jmi->n_z);*/
	/*printf("<<< %d %d\n", col_index, mask[col_index]);*/
	/*printf("<< %d %d\n", independent_vars, jmi_variable_type(jmi, col_index));*/
	int vt = 0;
	if (mask[col_index] == 0) {
		return 0;
	} else {
		vt = jmi_variable_type(jmi,col_index);
		if (vt!=-1 && (independent_vars & vt)) {
			return 1;
		} else {
			return 0;
		}
	}
}

int jmi_map_Jacobian_column_index(jmi_t *jmi, int independent_vars, int *mask, int col_index) {

/*	printf("jmi_map_Jacobian_column_index start: %d\n",col_index);*/
	int new_col_index = 0;
	int i = 0;

	for (i=0; i<col_index; i++) {
/*		printf("****************** 1 \n");*/
		if (jmi_check_Jacobian_column_index(jmi, independent_vars, mask, i)==1) {
			new_col_index++;
		}
/*		printf("****************** 2 \n");*/
	}

/*	printf("jmi_map_Jacobian_column_index end: %d\n",new_col_index);*/

	return new_col_index;
}

int jmi_variable_type_spec(jmi_t *jmi, int independent_vars,
			   int *mask, int col_index) {

  int spec_jac_index = 0;
  int i = 0;
  for(i=0;i<jmi->n_z;i++) {
    if (jmi_check_Jacobian_column_index(jmi,independent_vars,mask,i)==1) {
      spec_jac_index++;
    }
    if (col_index==spec_jac_index) {
      return jmi_variable_type(jmi,i);
    }
  }
  return -1;
}

int jmi_dae_get_sizes(jmi_t* jmi, int* n_eq_F, int* n_eq_R) {
	if (jmi->dae == NULL) {
		return -1;
	}
	*n_eq_F = jmi->dae->F->n_eq_F;
	*n_eq_R = jmi->dae->R->n_eq_F;
	return 0;
}

int jmi_init_get_sizes(jmi_t* jmi, int* n_eq_F0, int* n_eq_F1, int* n_eq_Fp,
		int* n_eq_R0) {
	if (jmi->init == NULL) {
		return -1;
	}
	*n_eq_F0 = jmi->init->F0->n_eq_F;
	*n_eq_F1 = jmi->init->F1->n_eq_F;
	*n_eq_Fp = jmi->init->Fp->n_eq_F;
	*n_eq_R0 = jmi->init->R0->n_eq_F;
	return 0;
}

int jmi_opt_get_sizes(jmi_t* jmi, int* n_eq_J, int* n_eq_L, int* n_eq_Ffdp,
		int* n_eq_Ceq, int* n_eq_Cineq, int* n_eq_Heq, int* n_eq_Hineq) {
	if (jmi->opt == NULL) {
		return -1;
	}
	*n_eq_J = jmi->opt->J->n_eq_F;
	*n_eq_L = jmi->opt->L->n_eq_F;
	*n_eq_Ffdp = jmi->opt->Ffdp->n_eq_F;
	*n_eq_Ceq = jmi->opt->Ceq->n_eq_F;
	*n_eq_Cineq = jmi->opt->Cineq->n_eq_F;
	*n_eq_Heq = jmi->opt->Heq->n_eq_F;
	*n_eq_Hineq = jmi->opt->Hineq->n_eq_F;
return 0;
}

int jmi_set_tp(jmi_t *jmi, jmi_real_t *tp) {
	int i;
	for (i=0;i<jmi->n_tp;i++) {
		jmi->tp[i] = tp[i];
	}
	return 0;
}

int jmi_get_n_tp(jmi_t *jmi, int *n_tp) {
	*n_tp = jmi->n_tp;
	return 0;
}

int jmi_get_tp(jmi_t *jmi, jmi_real_t *tp) {
	int i;
	if (jmi->tp != NULL) {
		for (i=0;i<jmi->n_tp;i++) {
			tp[i] = jmi->tp[i];
		}
		return 0;
	} else {
		return -1;
	}
}

int jmi_opt_get_optimization_interval(jmi_t *jmi, double *start_time, int *start_time_free,
		                              double *final_time, int *final_time_free) {
	*start_time = jmi->opt->start_time;
	*start_time_free = jmi->opt->start_time_free;
	*final_time = jmi->opt->final_time;
	*final_time_free = jmi->opt->final_time_free;
	return 0;
}


int jmi_opt_set_optimization_interval(jmi_t *jmi, double start_time, int start_time_free,
		 double final_time, int final_time_free) {
	jmi->opt->start_time = start_time;
	jmi->opt->start_time_free = start_time_free;
	jmi->opt->final_time = final_time;
	jmi->opt->final_time_free = final_time_free;
	return 0;
}

int jmi_opt_set_p_opt_indices(jmi_t *jmi, int n_p_opt, int *p_opt_indices) {
	int i;
	if (jmi->opt->p_opt_indices != NULL) {
		free(jmi->opt->p_opt_indices);
	}
	jmi->opt->n_p_opt = n_p_opt;
	jmi->opt->p_opt_indices = (int*)calloc(n_p_opt,sizeof(int));
	for (i=0;i<n_p_opt;i++) {
		jmi->opt->p_opt_indices[i] = p_opt_indices[i];
	}
	return 0;
}

int jmi_opt_get_n_p_opt(jmi_t *jmi, int *n_p_opt) {
	*n_p_opt = jmi->opt->n_p_opt;
	return 0;
}

int jmi_opt_get_p_opt_indices(jmi_t *jmi, int *p_opt_indices) {
	int i;
	if (jmi->opt->p_opt_indices != NULL) {
		for (i=0;i<jmi->opt->n_p_opt;i++) {
			p_opt_indices[i] = jmi->opt->p_opt_indices[i];
		}
	return 0;
	} else {
		return -1;
	}
}

jmi_real_t* jmi_get_z(jmi_t* jmi) {
	return *(jmi->z_val);
}

jmi_real_t* jmi_get_real_ci(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_real_ci;
}

jmi_real_t* jmi_get_real_cd(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_real_cd;
}

jmi_real_t* jmi_get_real_pi(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_real_pi;
}

jmi_real_t* jmi_get_real_pd(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_real_pd;
}

jmi_real_t* jmi_get_integer_ci(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_integer_ci;
}

jmi_real_t* jmi_get_integer_cd(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_integer_cd;
}

jmi_real_t* jmi_get_integer_pi(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_integer_pi;
}

jmi_real_t* jmi_get_integer_pd(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_integer_pd;
}

jmi_real_t* jmi_get_boolean_ci(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_boolean_ci;
}

jmi_real_t* jmi_get_boolean_cd(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_boolean_cd;
}

jmi_real_t* jmi_get_boolean_pi(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_boolean_pi;
}

jmi_real_t* jmi_get_boolean_pd(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_boolean_pd;
}

jmi_real_t* jmi_get_real_dx(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_real_dx;
}

jmi_real_t* jmi_get_real_x(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_real_x;
}

jmi_real_t* jmi_get_real_u(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_real_u;
}

jmi_real_t* jmi_get_real_w(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_real_w;
}

jmi_real_t* jmi_get_t(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_t;
}

jmi_real_t* jmi_get_real_dx_p(jmi_t* jmi, int i) {
	return *(jmi->z_val) + jmi->offs_real_dx_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i;
}

jmi_real_t* jmi_get_real_x_p(jmi_t* jmi, int i) {
	return *(jmi->z_val) + jmi->offs_real_x_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i;
}

jmi_real_t* jmi_get_real_u_p(jmi_t* jmi, int i) {
	return *(jmi->z_val) + jmi->offs_real_u_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i;
}

jmi_real_t* jmi_get_real_w_p(jmi_t* jmi, int i) {
	return *(jmi->z_val) + jmi->offs_real_w_p + (jmi->n_real_dx + jmi->n_real_x + jmi->n_real_u + jmi->n_real_w)*i;
}

jmi_real_t* jmi_get_real_d(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_real_d;
}

jmi_real_t* jmi_get_integer_d(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_integer_d;
}

jmi_real_t* jmi_get_integer_u(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_integer_u;
}

jmi_real_t* jmi_get_boolean_d(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_integer_d;
}

jmi_real_t* jmi_get_boolean_u(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_integer_u;
}

jmi_real_t* jmi_get_sw(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_sw;
}

jmi_real_t* jmi_get_sw_init(jmi_t* jmi) {
	return *(jmi->z_val) + jmi->offs_sw_init;
}

jmi_real_t* jmi_get_variable_scaling_factors(jmi_t* jmi) {
	return jmi->variable_scaling_factors;
}

int jmi_get_scaling_method(jmi_t* jmi) {
	return jmi->scaling_method;
}

void jmi_print_summary(jmi_t *jmi) {
	printf("Number of interactive constants:               %d\n",jmi->n_real_ci);
	printf("Number of dependent constants:                 %d\n",jmi->n_real_cd);
	printf("Number of interactive parameters:              %d\n",jmi->n_real_pi);
	printf("Number of dependent parameters:                %d\n",jmi->n_real_pd);
	printf("Number of derivatives:                         %d\n",jmi->n_real_dx);
	printf("Number of states:                              %d\n",jmi->n_real_x);
	printf("Number of inputs:                              %d\n",jmi->n_real_u);
	printf("Number of algebraics:                          %d\n",jmi->n_real_w);
	printf("Number of time points:                         %d\n",jmi->n_tp);
	printf("Number of switching functions in DAE:          %d\n",jmi->n_sw);
	printf("Number of switching functions in DAE init:     %d\n",jmi->n_sw_init);
	if (jmi->dae != NULL) {
		printf("DAE interface:\n");
		printf("  Number of DAE equations:                     %d\n",jmi->dae->F->n_eq_F);
	} else {
		printf("No DAE functions available");
	}
	if (jmi->init != NULL) {
		printf("Initialization interface:\n");
		printf("  Number of F0 equations:                      %d\n",jmi->init->F0->n_eq_F);
		printf("  Number of F1 equations:                      %d\n",jmi->init->F1->n_eq_F);
	} else {
		printf("No Initialization functions available");
	}
	if (jmi->opt != NULL) {
		printf("Optimization interface:\n");
		printf("  Number of Ceq constraints:                   %d\n",jmi->opt->Ceq->n_eq_F);
		printf("  Number of Cineq constraints:                 %d\n",jmi->opt->Cineq->n_eq_F);
		printf("  Number of Heq constraints:                   %d\n",jmi->opt->Heq->n_eq_F);
		printf("  Number of Hineq constraints:                 %d\n",jmi->opt->Hineq->n_eq_F);
	} else {
		printf("No Optimization functions available");
	}
}

void jmi_lin_interpolate(jmi_real_t x, jmi_real_t *z , int n ,int m,
		jmi_real_t *y) {

	int i;
	int el = 0;

	/* Check if before interval */
	if (x <= z[0]) {
		for (i=0;i<m-1;i++) {
/*			printf("%d: %f\n",i+1,z[n*(i+1)]);*/
			y[i] = z[n*(i+1)];
		}
		return;
	}
	/* Check after interval */
	if (x >= z[n-1]) {
		for (i=0;i<m-1;i++) {
			y[i] = z[n*(i+2)-1];
		}
		return;
	}

	/* Find correct element */
	while(x >= z[el]) {
		el++;
	}
	el--;

/*	printf(">> %d\n",el);*/

	/* Compute interpolated values. */
	for (i=0;i<m-1;i++) {
		y[i] = (x-z[el])*(z[n*(i+1) + el + 1] - z[n*(i+1) + el])/(z[el+1]-z[el]) +
		   z[n*(i+1) + el];
	}

}

int jmi_dae_derivative_checker(jmi_t* jmi, int sparsity, int independent_vars, int screen_use, int *mask){
	return jmi_util_dae_derivative_checker(jmi, jmi->dae->F, sparsity, independent_vars, screen_use, mask);
}


