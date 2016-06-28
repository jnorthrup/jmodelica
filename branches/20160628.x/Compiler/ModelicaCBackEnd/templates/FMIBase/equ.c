/*
    Copyright (C) 2015 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

$C_enum_strings$

$C_reinit_temp_decls$

$C_dae_blocks_residual_functions$

$CAD_dae_blocks_residual_functions$

void model_add_blocks(jmi_t** jmi) {
$C_dae_add_blocks_residual_functions$

$CAD_dae_add_blocks_residual_functions$
}

$C_ode_derivatives$

int model_ode_derivatives(jmi_t* jmi) {
    return model_ode_derivatives_base(jmi);
}

int model_ode_event_indicators(jmi_t* jmi, jmi_real_t** res) {
$C_DAE_event_indicator_residuals$
    return 0;
}
