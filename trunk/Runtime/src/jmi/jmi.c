/*
 * jmi.c contains pure C functions and does not support any AD functions.
 */


#include "jmi.h"

int jmi_init(jmi_t** jmi, int n_ci, int n_cd, int n_pi, int n_pd, int n_dx,
		int n_x, int n_u, int n_w, int n_tp) {

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

	jmi_->n_tp = n_tp;

	jmi_->offs_ci = 0;
	jmi_->offs_cd = n_ci;
	jmi_->offs_pi = n_ci + n_cd;
	jmi_->offs_pd = n_ci + n_cd + n_pi;
	jmi_->offs_dx = n_ci + n_cd + n_pi + n_pd;
	jmi_->offs_x = n_ci + n_cd + n_pi + n_pd + n_dx;
	jmi_->offs_u = n_ci + n_cd + n_pi + n_pd + n_dx + n_x;
	jmi_->offs_w = n_ci + n_cd + n_pi + n_pd + n_dx + n_x + n_u;
	jmi_->offs_t = n_ci + n_cd + n_pi + n_pd + n_dx + n_x + n_u + n_w;
	jmi_->offs_dx_p = jmi_->offs_t + 1;
	jmi_->offs_x_p = jmi_->offs_dx_p + n_dx*n_tp;
	jmi_->offs_u_p = jmi_->offs_x_p + n_x*n_tp;
	jmi_->offs_w_p = jmi_->offs_u_p + n_u*n_tp;
	jmi_->offs_t_p = jmi_->offs_w_p + n_w*n_tp;

	jmi_->offs_p = 0;
	jmi_->offs_v = jmi_->offs_dx;
	if (n_tp>0) {
		jmi_->offs_q = jmi_->offs_t + 1;
	} else {
		jmi_->offs_q = jmi_->offs_t;
	}

	jmi_->n_p = n_ci + n_cd + n_pi + n_pd;
	jmi_->n_v = n_dx + n_x + n_u + n_w + 1;
	jmi_->n_q = (n_dx + n_x + n_u + n_w + 1)*n_tp;

	jmi_->n_z = jmi_->n_p + jmi_->n_v + jmi_->n_q;

	jmi_->z = (jmi_ad_var_vec_p)calloc(1,sizeof(jmi_ad_var_vec_t));
	*(jmi_->z) = (jmi_ad_var_vec_t)calloc(jmi_->n_z,sizeof(jmi_ad_var_t));

	jmi_->z_val = (jmi_real_vec_p)calloc(1,sizeof(jmi_real_t));
	*(jmi_->z_val) =  (jmi_real_vec_t)calloc(jmi_->n_z,sizeof(jmi_real_t));

	return 0;

}

int jmi_ad_init(jmi_t* jmi) {
	return -1;
}

int jmi_delete(jmi_t* jmi){
	if(jmi->dae != NULL) {
		jmi_func_delete(jmi->dae->F);
		free(jmi->dae);
	}
	if(jmi->init != NULL) {
		jmi_func_delete(jmi->init->F0);
		jmi_func_delete(jmi->init->F1);
		free(jmi->init);
	}
	if(jmi->opt != NULL) {
		jmi_func_delete(jmi->opt->J);
		jmi_func_delete(jmi->opt->Ceq);
		jmi_func_delete(jmi->opt->Cineq);
		jmi_func_delete(jmi->opt->Heq);
		jmi_func_delete(jmi->opt->Hineq);
		free(jmi->opt);
	}
	free(*(jmi->z));
	free(*(jmi->z_val));
	free(jmi->z);
	free(jmi->z_val);
	free(jmi);

	return 0;
}

int jmi_dae_F(jmi_t* jmi, jmi_real_t* res) {

	int i;
	for (i=0;i<jmi->n_z;i++) {
		(*(jmi->z))[i] = (*(jmi->z_val))[i];
	}

	jmi->dae->F->F(jmi, &res);

	return 0;
}

int jmi_dae_dF(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int* mask, jmi_real_t* jac) {
	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF(jmi, jmi->dae->F, sparsity,
				independent_vars, mask, jac) ;


	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_dae_dF_n_nz(jmi_t* jmi, int eval_alg, int* n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_n_nz(jmi, jmi->dae->F, n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_dae_dF_nz_indices(jmi_t* jmi, int eval_alg, int* row, int* col) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_nz_indices(jmi, jmi->dae->F, row, col);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}

}

int jmi_dae_dF_dim(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_dim(jmi, jmi->dae->F, sparsity, independent_vars, mask,
				dF_n_cols, dF_n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}


}

int jmi_init_F0(jmi_t* jmi, jmi_real_t* res) {

	int i;
	for (i=0;i<jmi->n_z;i++) {
		(*(jmi->z))[i] = (*(jmi->z_val))[i];
	}

	jmi->init->F0->F(jmi, &res);

	return 0;
}

int jmi_init_dF0(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int* mask, jmi_real_t* jac) {
	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF(jmi, jmi->init->F0, sparsity,
				independent_vars, mask, jac) ;


	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_init_dF0_n_nz(jmi_t* jmi, int eval_alg, int* n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_n_nz(jmi, jmi->init->F0, n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_init_dF0_nz_indices(jmi_t* jmi, int eval_alg, int* row, int* col) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_nz_indices(jmi, jmi->init->F0, row, col);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}

}

int jmi_init_dF0_dim(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_dim(jmi, jmi->init->F0, sparsity, independent_vars, mask,
				dF_n_cols, dF_n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}


}


int jmi_init_F1(jmi_t* jmi, jmi_real_t* res) {

	int i;
	for (i=0;i<jmi->n_z;i++) {
		(*(jmi->z))[i] = (*(jmi->z_val))[i];
	}

	jmi->init->F1->F(jmi, &res);

	return 0;
}

int jmi_init_dF1(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int* mask, jmi_real_t* jac) {
	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF(jmi, jmi->init->F1, sparsity,
				independent_vars, mask, jac) ;


	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_init_dF1_n_nz(jmi_t* jmi, int eval_alg, int* n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_n_nz(jmi, jmi->init->F1, n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_init_dF1_nz_indices(jmi_t* jmi, int eval_alg, int* row, int* col) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_nz_indices(jmi, jmi->init->F1, row, col);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}

}

int jmi_init_dF1_dim(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_dim(jmi, jmi->init->F1, sparsity, independent_vars, mask,
				dF_n_cols, dF_n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_J(jmi_t* jmi, jmi_real_t* res) {

	int i;
	for (i=0;i<jmi->n_z;i++) {
		(*(jmi->z))[i] = (*(jmi->z_val))[i];
	}

	jmi->opt->J->F(jmi, &res);

	return 0;
}

int jmi_opt_dJ(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int* mask, jmi_real_t* jac) {
	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF(jmi, jmi->opt->J, sparsity,
				independent_vars, mask, jac) ;


	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_dJ_n_nz(jmi_t* jmi, int eval_alg, int* n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_n_nz(jmi, jmi->opt->J, n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_dJ_nz_indices(jmi_t* jmi, int eval_alg, int* row, int* col) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_nz_indices(jmi, jmi->opt->J, row, col);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}

}

int jmi_opt_dJ_dim(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_dim(jmi, jmi->opt->J, sparsity, independent_vars, mask,
				dF_n_cols, dF_n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_Ceq(jmi_t* jmi, jmi_real_t* res) {

	int i;
	for (i=0;i<jmi->n_z;i++) {
		(*(jmi->z))[i] = (*(jmi->z_val))[i];
	}

	jmi->opt->Ceq->F(jmi, &res);

	return 0;
}

int jmi_opt_dCeq(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int* mask, jmi_real_t* jac) {
	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF(jmi, jmi->opt->Ceq, sparsity,
				independent_vars, mask, jac) ;


	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_dCeq_n_nz(jmi_t* jmi, int eval_alg, int* n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_n_nz(jmi, jmi->opt->Ceq, n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_dCeq_nz_indices(jmi_t* jmi, int eval_alg, int* row, int* col) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_nz_indices(jmi, jmi->opt->Ceq, row, col);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}

}

int jmi_opt_dCeq_dim(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_dim(jmi, jmi->opt->Ceq, sparsity, independent_vars, mask,
				dF_n_cols, dF_n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_Cineq(jmi_t* jmi, jmi_real_t* res) {

	int i;
	for (i=0;i<jmi->n_z;i++) {
		(*(jmi->z))[i] = (*(jmi->z_val))[i];
	}

	jmi->opt->Cineq->F(jmi, &res);

	return 0;
}

int jmi_opt_dCineq(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int* mask, jmi_real_t* jac) {
	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF(jmi, jmi->opt->Cineq, sparsity,
				independent_vars, mask, jac) ;


	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_dCineq_n_nz(jmi_t* jmi, int eval_alg, int* n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_n_nz(jmi, jmi->opt->Cineq, n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_dCineq_nz_indices(jmi_t* jmi, int eval_alg, int* row, int* col) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_nz_indices(jmi, jmi->opt->Cineq, row, col);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}

}

int jmi_opt_dCineq_dim(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_dim(jmi, jmi->opt->Cineq, sparsity, independent_vars, mask,
				dF_n_cols, dF_n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_Heq(jmi_t* jmi, jmi_real_t* res) {

	int i;
	for (i=0;i<jmi->n_z;i++) {
		(*(jmi->z))[i] = (*(jmi->z_val))[i];
	}

	jmi->opt->Heq->F(jmi, &res);

	return 0;
}

int jmi_opt_dHeq(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int* mask, jmi_real_t* jac) {
	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF(jmi, jmi->opt->Heq, sparsity,
				independent_vars, mask, jac) ;


	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_dHeq_n_nz(jmi_t* jmi, int eval_alg, int* n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_n_nz(jmi, jmi->opt->Heq, n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_dHeq_nz_indices(jmi_t* jmi, int eval_alg, int* row, int* col) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_nz_indices(jmi, jmi->opt->Heq, row, col);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}

}

int jmi_opt_dHeq_dim(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_dim(jmi, jmi->opt->Heq, sparsity, independent_vars, mask,
				dF_n_cols, dF_n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_Hineq(jmi_t* jmi, jmi_real_t* res) {

	int i;
	for (i=0;i<jmi->n_z;i++) {
		(*(jmi->z))[i] = (*(jmi->z_val))[i];
	}

	jmi->opt->Hineq->F(jmi, &res);

	return 0;
}

int jmi_opt_dHineq(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int* mask, jmi_real_t* jac) {
	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF(jmi, jmi->opt->Hineq, sparsity,
				independent_vars, mask, jac) ;


	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_dHineq_n_nz(jmi_t* jmi, int eval_alg, int* n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_n_nz(jmi, jmi->opt->Hineq, n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}

int jmi_opt_dHineq_nz_indices(jmi_t* jmi, int eval_alg, int* row, int* col) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_nz_indices(jmi, jmi->opt->Hineq, row, col);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}

}

int jmi_opt_dHineq_dim(jmi_t* jmi, int eval_alg, int sparsity, int independent_vars, int *mask,
		int *dF_n_cols, int *dF_n_nz) {

	if (eval_alg & JMI_DER_SYMBOLIC) {

		return jmi_func_dF_dim(jmi, jmi->opt->Hineq, sparsity, independent_vars, mask,
				dF_n_cols, dF_n_nz);

	} else if (eval_alg & JMI_DER_CPPAD) {
		return -1;
	} else {
		return -1;
	}
}















