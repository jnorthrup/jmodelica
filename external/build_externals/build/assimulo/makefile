
include default_config
include $(USER_CONFIG)

.PHONY: wheel folder

test:
	nosetests tests/*.pyc tests/solvers/*.pyc

test_wheel: $(INSTALL_DIR_FOLDER)/$(subst test_,,$@)
	@pip install $(INSTALL_DIR_FOLDER)/$(subst test_,,$@)/*.whl
	nosetests $(WHEEL_INSTALL_DIR)/tests/*.pyc $(WHEEL_INSTALL_DIR)/tests/solvers/*.pyc

test_folder: $(INSTALL_DIR_FOLDER)/$(subst test_,,$@)
	nosetests $(ASSIMULO_FOLDER_INSTALL_DIR)/tests/*.pyc $(ASSIMULO_FOLDER_INSTALL_DIR)/tests/solvers/*.pyc

folder: $(PREINSTALL_DIR) debug_var

debug_var:
	ls -la $(PREINSTALL_DIR)

$(PREINSTALL_DIR): 
	@$(eval TARGET_BUILD_DIR=$(BUILD_DIR)/Assimulo_build$(BITNESS))
	mkdir -p $(TARGET_BUILD_DIR)
	mkdir -p $@
	cd $(ASSIMULO_SRC) && \
	find . -type f | grep -v -E '/.svn|.pyc' |tar c -T - | tar x -C $(TARGET_BUILD_DIR)
	cd $(TARGET_BUILD_DIR); \
	$(PYTHONHOME)python setup.py $(BUILD_SETUP_EXTRA) install --superlu-home=$(SUPERLU_HOME) --sundials-home=$(SUNDIALS_HOME) --sundials-with-superlu=True --blas-home=$(BLAS_HOME) --lapack-home=$(LAPACK_HOME) $(EXTRA_SETUP_ARGS) --prefix=$@ --mkl-home=$(MKL_HOME)
	echo "(DEBUG): Searching for all directories named tests"
	find $(JM_HOME) -type d -name "tests"

install: folder
	@echo "makefile: Got PREINSTALL_DIR=$(PREINSTALL_DIR)"
	mkdir -p $(INSTALL_DIR_FOLDER)
	cd $(PREINSTALL_DIR); \
	find $(PREINSTALL_DIR) -type d -name assimulo -exec cp -r {} $(INSTALL_DIR_FOLDER)/ \;

wheel: $(INSTALL_DIR_FOLDER)/wheel

$(INSTALL_DIR_FOLDER)/wheel:
	@$(eval TARGET_BUILD_DIR=$(BUILD_DIR)/wheel_build)
	mkdir -p $(TARGET_BUILD_DIR)
	mkdir -p $@
	cd $(ASSIMULO_SRC) && \
	find . -type f | grep -v -E '/.svn|.pyc' |tar c -T - -f - | tar x -C $(TARGET_BUILD_DIR)
	cd $(TARGET_BUILD_DIR); \
	$(PYTHONHOME)python setup.py $(BUILD_SETUP_EXTRA) bdist_wheel --superlu-home=$(SUPERLU_HOME) --sundials-home=$(SUNDIALS_HOME) --sundials-with-superlu=True --blas-home=$(BLAS_HOME) --lapack-home=$(LAPACK_HOME) --mkl-home=$(MKL_HOME) $(EXTRA_SETUP_ARGS); \
	find -type f -name Assimulo*.whl -exec cp {} $@/ \;

clean:
	@$(eval TARGET_BUILD_DIR=$(BUILD_DIR)/Assimulo_build*)
	rm -rf $(TARGET_BUILD_DIR) $(INSTALL_DIR_FOLDER)
ifeq ($(REMOVE_PREINSTALL_DIR), yes)
	@echo "Removing $(PREINSTALL_DIR)" && rm -rf $(PREINSTALL_DIR)
endif

#
#	Copyright (C) 2018 Modelon AB
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
