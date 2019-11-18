#
#	Copyright (C) 2019 Modelon AB
#
#	This program is free software: you can redistribute it and/or modify
#	it under the terms of the GNU General Public License version 3 as published 
#	by the Free Software Foundation, or optionally, under the terms of the 
#	Common Public License version 1.0 as published by IBM.
#
#	This program is distributed in the hope that it will be useful,
#	but WITHOUT ANY WARRANTY; without even the implied warranty of
#	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#	GNU General Public License, or the Common Public License, for more details.
#
#	You should have received copies of the GNU General Public License
#	and the Common Public License along with this program.  If not, 
#	see <http://www.gnu.org/licenses/> or 
#	<http://www.ibm.com/developerworks/library/os-cpl.html/> respectively.

include_directories(${CMAKE_CURRENT_SOURCE_DIR}/../src)

if(NOT SUPERLU_PRECISIONS)
  set(SUPERLU_PRECISIONS SINGLE DOUBLE COMPLEX COMPLEX16)
endif(NOT SUPERLU_PRECISIONS)


set(ALLAUX_LU_SRCS
  superlu_timer.c dclock.c sp_ienv.c lsame.c xerbla.c   
  util.c pmemory.c qrnzcnt.c cholnzcnt.c await.c   
  get_perm_c.c mmd.c colamd.c sp_coletree.c   
  pxgstrf_scheduler.c sp_colorder.c   
  pxgstrf_mark_busy_descends.c   
  pxgstrf_pruneL.c pxgstrf_super_bnd_dfs.c   
  pxgstrf_relax_snode.c heap_relax_snode.c   
  pxgstrf_synch.c pxgstrf_finalize.c
  )

if(MSVC)
 set(NOOPT_FLAG /Od)
else()
 set(NOOPT_FLAG -O0)
endif()

set(NOOPT_FILES superlu_timer.c dlamch.c slamch.c dclock.c)
foreach(noopt_file ${NOOPT_FILES})
    set_source_files_properties(${noopt_file} PROPERTIES COMPILE_FLAGS "${NOOPT_FLAG}")
endforeach(noopt_file ${NOOPT_FILES})

set(SINGLE_LU_SRCS 
  sreadhb.c sreadrb.c smatgen.c 
  psgssv.c psgssvx.c sgstrs.c sgsrfs.c 
  sgscon.c slacon.c slangs.c sgsequ.c slaqgs.c spivotgrowth.c 
  psmemory.c psutil.c smyblas2.c 
  psgstrf.c psgstrf_init.c 
  psgstrf_thread.c psgstrf_thread_init.c psgstrf_thread_finalize.c 
  psgstrf_factor_snode.c psgstrf_snode_dfs.c psgstrf_snode_bmod.c 
  psgstrf_panel_dfs.c psgstrf_panel_bmod.c 
  psgstrf_copy_to_ucol.c psgstrf_pivotL.c 
  psgstrf_column_dfs.c psgstrf_column_bmod.c 
  psgstrf_bmod1D.c psgstrf_bmod2D.c 
  psgstrf_bmod1D_mv2.c psgstrf_bmod2D_mv2.c 
  ssp_blas2.c ssp_blas3.c
  )

set(DOUBLE_LU_SRCS 
  dreadhb.c dreadrb.c dmatgen.c 
  pdgssv.c pdgssvx.c dgstrs.c dgsrfs.c 
  dgscon.c dlacon.c dlangs.c dgsequ.c dlaqgs.c dpivotgrowth.c 
  pdmemory.c pdutil.c dmyblas2.c 
  pdgstrf.c pdgstrf_init.c 
  pdgstrf_thread.c pdgstrf_thread_init.c pdgstrf_thread_finalize.c 
  pdgstrf_factor_snode.c pdgstrf_snode_dfs.c pdgstrf_snode_bmod.c 
  pdgstrf_panel_dfs.c pdgstrf_panel_bmod.c 
  pdgstrf_copy_to_ucol.c pdgstrf_pivotL.c 
  pdgstrf_column_dfs.c pdgstrf_column_bmod.c 
  pdgstrf_bmod1D.c pdgstrf_bmod2D.c 
  pdgstrf_bmod1D_mv2.c pdgstrf_bmod2D_mv2.c 
  dsp_blas2.c dsp_blas3.c 
  )


set(COMPLEX_LU_SRCS
  scomplex.c creadhb.c creadrb.c cmatgen.c scsum1.c icmax1.c   
  pcgssv.c pcgssvx.c cgstrs.c cgsrfs.c   
  cgscon.c clacon.c clangs.c cgsequ.c claqgs.c cpivotgrowth.c   
  pcmemory.c pcutil.c cmyblas2.c   
  pcgstrf.c pcgstrf_init.c   
  pcgstrf_thread.c pcgstrf_thread_init.c pcgstrf_thread_finalize.c   
  pcgstrf_factor_snode.c pcgstrf_snode_dfs.c pcgstrf_snode_bmod.c   
  pcgstrf_panel_dfs.c pcgstrf_panel_bmod.c   
  pcgstrf_copy_to_ucol.c pcgstrf_pivotL.c   
  pcgstrf_column_dfs.c pcgstrf_column_bmod.c   
  pcgstrf_bmod1D.c pcgstrf_bmod2D.c   
  pcgstrf_bmod1D_mv2.c pcgstrf_bmod2D_mv2.c   
  csp_blas2.c csp_blas3.c
  )

set(COMPLEX16_LU_SRCS 
  dcomplex.c zreadhb.c zreadrb.c zmatgen.c dzsum1.c izmax1.c   
  pzgssv.c pzgssvx.c zgstrs.c zgsrfs.c   
  zgscon.c zlacon.c zlangs.c zgsequ.c zlaqgs.c zpivotgrowth.c   
  pzmemory.c pzutil.c zmyblas2.c   
  pzgstrf.c pzgstrf_init.c   
  pzgstrf_thread.c pzgstrf_thread_init.c pzgstrf_thread_finalize.c   
  pzgstrf_factor_snode.c pzgstrf_snode_dfs.c pzgstrf_snode_bmod.c   
  pzgstrf_panel_dfs.c pzgstrf_panel_bmod.c   
  pzgstrf_copy_to_ucol.c pzgstrf_pivotL.c   
  pzgstrf_column_dfs.c pzgstrf_column_bmod.c   
  pzgstrf_bmod1D.c pzgstrf_bmod2D.c   
  pzgstrf_bmod1D_mv2.c pzgstrf_bmod2D_mv2.c   
  zsp_blas2.c zsp_blas3.c
  )

set(SUPERLU_SRCS ${ALLAUX_LU_SRCS})
foreach(precision ${SUPERLU_PRECISIONS})
  set(SUPERLU_SRCS ${SUPERLU_SRCS} ${${precision}_LA_SRCS} ${${precision}_AUX_SRCS} ${${precision}_LU_SRCS})
endforeach(precision ${SUPERLU_PRECISIONS})
list(REMOVE_DUPLICATES SUPERLU_SRCS)

set(SUPERLU_INCLUDE_FILES
  colamd.h
  pxgstrf_synch.h
  slu_mt_cdefs.h
  slu_mt_Cnames.h
  slu_dcomplex.h
  slu_mt_ddefs.h
  slu_scomplex.h
  slu_mt_sdefs.h
  slu_mt_util.h
  slu_mt_zdefs.h
  slu_mt_machines.h
  supermatrix.h
  )
  
add_library(superlu_mt${SUPERLU_SUFFIX} STATIC ${SUPERLU_SRCS})

install(TARGETS superlu_mt${SUPERLU_SUFFIX}
  RUNTIME DESTINATION ${SUPERLU_INSTALL_DIR}/bin
  LIBRARY DESTINATION ${SUPERLU_INSTALL_DIR}/lib
  ARCHIVE DESTINATION ${SUPERLU_INSTALL_DIR}/lib)

install(FILES ${SUPERLU_INCLUDE_FILES} DESTINATION ${SUPERLU_INSTALL_DIR}/include)