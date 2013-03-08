<!--
    Copyright (C) 2009 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
-->
<?xml version="1.0" encoding="UTF-8"?>
<fmiModelDescription $XML_rootAttributes$>
	$XML_unitDefinitions$	
	$XML_typeDefinitions$
	$XML_defaultExperiment$
	$XML_vendorAnnotations$	
	<ModelVariables>$XML_variables$
	</ModelVariables>
	$XML_modelStructure$
    <Implementation>
    <CoSimulation_StandAlone>
      <Capabilities
        canHandleVariableCommunicationStepSize="true"
        canHandleEvents="false"
        canRejectSteps="false"
        canInterpolateInputs="false"
        maxOutputDerivativeOrder="0"
        canRunAsynchronuously="false"
        canSignalEvents="false"
        canBeInstantiatedOnlyOncePerProcess="true"
        canNotUseMemoryManagementFunctions="false"/>
    </CoSimulation_StandAlone>
  </Implementation>
</fmiModelDescription>
