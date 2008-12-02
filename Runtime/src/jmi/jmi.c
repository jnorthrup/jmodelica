
#include "jmi.h"

#define JMI_DAE_COMPUTE_DF_DIM_PART(independent_vars_mask, n_vars, jmi_dF_n_nz, jmi_dF_icol) {\
	if ((independent_vars & independent_vars_mask)) {\
		for (i=0;i<n_vars;i++) {\
			if (mask[col_index]) {\
				(*dF_n_cols)++;\
				if (sparsity & JMI_DER_SPARSE) {\
					for (j=0;j<jmi_dF_n_nz;j++) {\
						/*printf("%d, %d, %d\n",jmi->dae->dF_n_nz,jmi->dae->dF_icol[j]-1,col_index);*/\
	(*dF_n_nz) += jmi_dF_icol[j]-1 == col_index? 1 : 0;\
					}\
				} else {\
					(*dF_n_nz) += jmi->dae->F->n_eq_Y;\
				}\
			}\
			col_index++;\
		}\
	} else {\
		col_index += n_vars;\
	}\
}\


int jmi_init(jmi_t** jmi, int n_ci, int n_cd, int n_pi, int n_pd, int n_dx,
		int n_x, int n_u, int n_w) {

	// Create jmi struct
	*jmi = (jmi_t*)calloc(1,sizeof(jmi_t));
	jmi_t* jmi_ = *jmi;
	// Set struct pointers in jmi
	jmi_->dae = NULL;
	jmi_->init = NULL;
	jmi_->opt = NULL;

	// Set sizes of dae vectors
	jmi_->n_ci = n_ci;
	jmi_->n_cd = n_cd;
	jmi_->n_pi = n_pi;
	jmi_->n_pd = n_pd;
	jmi_->n_dx = n_dx;
	jmi_->n_x = n_x;
	jmi_->n_u = n_u;
	jmi_->n_w = n_w;

	jmi_->offs_ci = 0;
	jmi_->offs_cd = n_ci;
	jmi_->offs_pi = n_ci + n_cd;
	jmi_->offs_pd = n_ci + n_cd + n_pi;
	jmi_->offs_dx = n_ci + n_cd + n_pi + n_pd;
	jmi_->offs_x = n_ci + n_cd + n_pi + n_pd + n_dx;
	jmi_->offs_u = n_ci + n_cd + n_pi + n_pd + n_dx + n_x;
	jmi_->offs_w = n_ci + n_cd + n_pi + n_pd + n_dx + n_x + n_u;
	jmi_->offs_t = n_ci + n_cd + n_pi + n_pd + n_dx + n_x + n_u + n_w;

	jmi_->n_z = n_ci + n_cd + n_pi + n_pd + n_dx +
	n_x + n_u + n_w + 1;

	jmi_->z = (jmi_ad_var_vec_p)calloc(1,sizeof(jmi_ad_var_vec_t));
	*(jmi_->z) = (jmi_ad_var_vec_t)calloc(jmi_->n_z,sizeof(jmi_ad_var_t));

	jmi_->z_val = (jmi_real_vec_p)calloc(1,sizeof(jmi_real_t));
	*(jmi_->z_val) =  (jmi_real_vec_t)calloc(jmi_->n_z,sizeof(jmi_real_t));

	return 0;

}

int jmi_dae_init(jmi_t* jmi, jmi_residual_func_t jmi_dae_F, int n_eq_F, jmi_jacobian_func_t jmi_dae_dF,
		int dF_n_nz, int* irow, int* icol) {

	int i;

	// Create jmi_dae struct
	jmi_dae_t* dae = (jmi_dae_t*)calloc(1,sizeof(jmi_dae_t));
	jmi->dae = dae;
	jmi_func_t* jf_F = (jmi_func_t*)calloc(1,sizeof(jmi_func_t));
	jmi->dae->F = jf_F;

	// Set up the dae struct
	dae->F->n_eq_Y = n_eq_F;
	dae->F->Y = jmi_dae_F;
	dae->F->dY = jmi_dae_dF;

	dae->F->dY_n_nz = dF_n_nz;
	dae->F->dY_irow = (int*)calloc(dF_n_nz,sizeof(int));
	dae->F->dY_icol = (int*)calloc(dF_n_nz,sizeof(int));

	for (i=0;i<dF_n_nz;i++) {
		dae->F->dY_irow[i] = irow[i];
		dae->F->dY_icol[i] = icol[i];
	}

	dae->F->ad = NULL;

	return 0;
}

int jmi_init_init(jmi_t* jmi, jmi_residual_func_t jmi_init_F0, int n_eq_F0,
		jmi_jacobian_func_t jmi_init_dF0,
		int dF0_n_nz, int* dF0_irow, int* dF0_icol,
		jmi_residual_func_t jmi_init_F1, int n_eq_F1,
		jmi_jacobian_func_t jmi_init_dF1,
		int dF1_n_nz, int* dF1_irow, int* dF1_icol) {


	return 0;
}

int jmi_ad_init(jmi_t* jmi) {
	return -1;
}

int jmi_delete(jmi_t* jmi){
	if(jmi->dae != NULL) {
		free(jmi->dae->F->dY_irow);
		free(jmi->dae->F->dY_icol);
		free(jmi->dae);
	}
	if(jmi->init != NULL) {
		free(jmi->init);
	}
	if(jmi->opt != NULL) {
		free(jmi->opt);
	}
	free(*(jmi->z));
	free(*(jmi->z_val));
	free(jmi->z);
	free(jmi->z_val);
	free(jmi);

	return 0;
}

int jmi_get_sizes(jmi_t* jmi, int* n_ci, int* n_cd, int* n_pi, int* n_pd,
		                        int* n_dx, int* n_x, int* n_u, int* n_w) {

	*n_ci = jmi->n_ci;
	*n_cd = jmi->n_cd;
	*n_pi = jmi->n_pi;
	*n_pd = jmi->n_pd;
	*n_dx = jmi->n_dx;
	*n_x = jmi->n_x;
	*n_u = jmi->n_u;
	*n_w = jmi->n_w;

	return 0;
}

int jmi_dae_get_sizes(jmi_t* jmi, int* n_eq_F) {
	*n_eq_F = jmi->dae->F->n_eq_Y;
	return 0;
}

int jmi_get_ci(jmi_t* jmi, jmi_real_t** ci) {
	*ci = *(jmi->z_val) + jmi->offs_ci;
	return 0;
}

int jmi_get_cd(jmi_t* jmi, jmi_real_t** cd) {
	*cd = *(jmi->z_val) + jmi->offs_cd;
	return 0;
}

int jmi_get_pi(jmi_t* jmi, jmi_real_t** pi) {
	*pi = *(jmi->z_val) + jmi->offs_pi;
	return 0;
}

int jmi_get_pd(jmi_t* jmi, jmi_real_t** pd) {
	*pd = *(jmi->z_val) + jmi->offs_pd;
	return 0;
}

int jmi_get_dx(jmi_t* jmi, jmi_real_t** dx) {
	*dx = *(jmi->z_val) + jmi->offs_dx;
	return 0;
}

int jmi_get_x(jmi_t* jmi, jmi_real_t** x) {
	*x = *(jmi->z_val) + jmi->offs_x;
	return 0;
}

int jmi_get_u(jmi_t* jmi, jmi_real_t** u) {
	*u = *(jmi->z_val) + jmi->offs_u;
	return 0;
}

int jmi_get_w(jmi_t* jmi, jmi_real_t** w) {
	*w = *(jmi->z_val) + jmi->offs_w;
	return 0;
}

int jmi_get_t(jmi_t* jmi, jmi_real_t** t) {
	*t = *(jmi->z_val) + jmi->offs_t;
	return 0;
}

int jmi_dae_F(jmi_t* jmi, jmi_real_t* res) {
	int i;
	for (i=0;i<jmi->n_z;i++) {
		(*(jmi->z))[i] = (*(jmi->z_val))[i];
	}

	jmi->dae->F->Y(jmi, &res);
	return 0;
}

int jmi_dae_dF(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int* mask, jmi_real_t* jac) {
	if (eval_alg & JMI_DER_SYMBOLIC) {

		if (jmi->dae->F->dY==NULL) {
			return -1;
		}
		int i;
		for (i=0;i<jmi->n_z;i++) {
			(*(jmi->z))[i] = (*(jmi->z_val))[i];
		}
		jmi->dae->F->dY(jmi, sparsity, independent_vars, mask, jac);
		return 0;

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_dae_dF_n_nz(jmi_t* jmi, int eval_alg, int* n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {
		if (jmi->dae->F->dY==NULL) {
			return -1;
		}
		*n_nz = jmi->dae->F->dY_n_nz;
		return 0;

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_dae_dF_nz_indices(jmi_t* jmi, int eval_alg, int* row, int* col) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		if (jmi->dae->F->dY==NULL) {
			return -1;
		}
		int i;
		for (i=0;i<jmi->dae->F->dY_n_nz;i++) {
			row[i] = jmi->dae->F->dY_irow[i];
			col[i] = jmi->dae->F->dY_icol[i];
		}
		return 0;

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}

}

int jmi_dae_dF_dim(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {
	if (eval_alg & JMI_DER_SYMBOLIC) {

		if (jmi->dae->F->dY==NULL) {
			return -1;
		}

		*dF_n_cols = 0;
		*dF_n_nz = 0;

		int i,j;
		int col_index = 0;

		JMI_DAE_COMPUTE_DF_DIM_PART(JMI_DER_CI, jmi->n_ci, jmi->dae->F->dY_n_nz, jmi->dae->F->dY_icol)
		JMI_DAE_COMPUTE_DF_DIM_PART(JMI_DER_CD, jmi->n_cd, jmi->dae->F->dY_n_nz, jmi->dae->F->dY_icol)
		JMI_DAE_COMPUTE_DF_DIM_PART(JMI_DER_PI, jmi->n_pi, jmi->dae->F->dY_n_nz, jmi->dae->F->dY_icol)
		JMI_DAE_COMPUTE_DF_DIM_PART(JMI_DER_PD, jmi->n_pd, jmi->dae->F->dY_n_nz, jmi->dae->F->dY_icol)
		JMI_DAE_COMPUTE_DF_DIM_PART(JMI_DER_DX, jmi->n_dx, jmi->dae->F->dY_n_nz, jmi->dae->F->dY_icol)
		JMI_DAE_COMPUTE_DF_DIM_PART(JMI_DER_X, jmi->n_x, jmi->dae->F->dY_n_nz, jmi->dae->F->dY_icol)
		JMI_DAE_COMPUTE_DF_DIM_PART(JMI_DER_U, jmi->n_u, jmi->dae->F->dY_n_nz, jmi->dae->F->dY_icol)
		JMI_DAE_COMPUTE_DF_DIM_PART(JMI_DER_W, jmi->n_w, jmi->dae->F->dY_n_nz, jmi->dae->F->dY_icol)
		JMI_DAE_COMPUTE_DF_DIM_PART(JMI_DER_T, 1, jmi->dae->F->dY_n_nz, jmi->dae->F->dY_icol)

		return 0;

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}


}
