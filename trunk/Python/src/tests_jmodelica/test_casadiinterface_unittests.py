#Copyright (C) 2013 Modelon AB

#This program is free software: you can redistribute it and/or modify
#it under the terms of the GNU General Public License as published by
#the Free Software Foundation, version 3 of the License.

#This program is distributed in the hope that it will be useful,
#but WITHOUT ANY WARRANTY; without even the implied warranty of
#MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#GNU General Public License for more details.

#You should have received a copy of the GNU General Public License
#along with this program.  If not, see <http://www.gnu.org/licenses/>.

from tests_jmodelica import testattr
from modelicacasadi_transfer import *

@testattr(casadi = True)    
def test_SharedNode_eq():
    m = Model()
    realVar1 = RealVariable(m, MX("node1"), Variable.INTERNAL, Variable.CONTINUOUS)
    # Since == and != are implemented separately, we test both
    assert realVar1 == realVar1
    assert not (realVar1 != realVar1)
    # Test that we can compare a SharedNode to a regular Python object
    assert realVar1 != 1
    assert not (realVar1 == 1)

@testattr(casadi = True)    
def test_VariableAlias():
    model = Model()
    realVar1 = RealVariable(model, MX("node1"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar2 = RealVariable(model, MX("node2"), Variable.INTERNAL, Variable.CONTINUOUS)
    # Default values
    assert not realVar1.isAlias()
    assert realVar1.getModelVariable() == realVar1
    assert not realVar1.isNegated()
    
    # Try to set negated attribute, even though it is not an alias variable yet. 
    import sys
    errorString = ""
    try:
        realVar1.setNegated(True)
    except:
        errorString = sys.exc_info()[1].message 
    assert errorString == "Only alias variables may be negated";
    
    
    # Make realVar1 an AliasVariables
    realVar1.setAlias(realVar2)
    # Check updated attributes, results of getters etc. 
    assert realVar1.isAlias()
    assert not realVar2.isAlias()
    assert realVar1.getModelVariable() == realVar2
    assert not realVar1.isNegated()
    # Set negated, and check
    realVar1.setNegated(True)
    assert realVar1.isNegated()
    
    # Set and check attributes. 
    # Attributes that are set in an alias variable are propagated to its model variable. 
    # Attributes that are set in a model variable are accessed by its alias.
    anMX = MX("mx")
    realVar1.setAttribute("attr", anMX)
    assert realVar1.getAttribute("attr").isEqual(anMX)
    assert realVar2.getAttribute("attr").isEqual(anMX)
    anotherMX = MX("mx2")
    realVar2.setAttribute("anotherAttr", anotherMX)
    assert realVar1.getAttribute("anotherAttr").isEqual(anotherMX)
    assert realVar2.getAttribute("anotherAttr").isEqual(anotherMX)
    
    # Add the variables to a Model and make sure that the distinction between the 
    # function getVariable and getModelVariable works.
    model.addVariable(realVar1)
    model.addVariable(realVar2)
    assert model.getVariable("node1") == realVar1
    assert model.getVariable("node2") == realVar2
    assert model.getModelVariable("node1") == realVar2
    assert model.getModelVariable("node2") == realVar2

@testattr(casadi = True)    
def test_NegatedAliasAttributes():
    m = Model()
    realVar1 = RealVariable(m, MX("node1"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar2 = RealVariable(m, MX("node2"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar3 = RealVariable(m, MX("node3"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar1.setAlias(realVar3)
    realVar2.setAlias(realVar3)
    realVar1.setNegated(True)
    attr1 = MX("attr1")
    attr2 = MX("attr2")
    attr3 = MX("attr3")
    attr4 = MX("attr4")

    # Set attributes affected by negation on model variable
    realVar3.setAttribute("min", attr1)
    realVar3.setAttribute("max", attr2)
    realVar3.setAttribute("start", attr3)
    realVar3.setAttribute("nominal", attr4)

    # Check correctness for negated and non-negated alias. 
    assert isEqual(realVar1.getAttribute("min"), -attr2)
    assert isEqual(realVar1.getAttribute("max"), -attr1)
    assert isEqual(realVar1.getAttribute("start"), -attr3)
    assert isEqual(realVar1.getAttribute("nominal"), -attr4)

    assert isEqual(realVar2.getAttribute("min"), attr1)
    assert isEqual(realVar2.getAttribute("max"), attr2)
    assert isEqual(realVar2.getAttribute("start"), attr3)
    assert isEqual(realVar2.getAttribute("nominal"), attr4)

    # Set attributes on negated alias
    realVar1.setAttribute("min", attr1)
    realVar1.setAttribute("max", attr2)
    realVar1.setAttribute("start", attr3)
    realVar1.setAttribute("nominal", attr4)

    # Check that the attributes are propagated correctly
    assert isEqual(realVar1.getAttribute("min"), attr1)
    assert isEqual(realVar1.getAttribute("max"), attr2)
    assert isEqual(realVar1.getAttribute("start"), attr3)
    assert isEqual(realVar1.getAttribute("nominal"), attr4)

    assert isEqual(realVar2.getAttribute("min"), -attr2)
    assert isEqual(realVar2.getAttribute("max"), -attr1)
    assert isEqual(realVar2.getAttribute("start"), -attr3)
    assert isEqual(realVar2.getAttribute("nominal"), -attr4)

    assert isEqual(realVar3.getAttribute("min"), -attr2)
    assert isEqual(realVar3.getAttribute("max"), -attr1)
    assert isEqual(realVar3.getAttribute("start"), -attr3)
    assert isEqual(realVar3.getAttribute("nominal"), -attr4)

    
@testattr(casadi = True)    
def test_ModelAliasAndModelGetters():
    model = Model()
    realVar1 = RealVariable(model, MX("node1"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar2 = RealVariable(model, MX("node2"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar3 = RealVariable(model, MX("node3"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar1.setAlias(realVar3)
    realVar2.setAlias(realVar3)
    realVar1.setNegated(True)
    model.addVariable(realVar1)
    model.addVariable(realVar2)
    model.addVariable(realVar3)
    modelVars = model.getModelVariables()
    aliasVars = model.getAliases()
    assert isEqual(modelVars[0].getVar(), realVar3.getVar())
    assert isEqual(aliasVars[0].getVar(), realVar1.getVar())
    assert isEqual(aliasVars[1].getVar(), realVar2.getVar())

@testattr(casadi = True)    
def test_DependentParameters():
    model = Model()

    a = MX("a")
    b = MX("b")
    c = MX("c")
    d = MX("d")
    e = MX("e")
    funcVar = MX("funcVar")
    f = MXFunction([funcVar], [funcVar*2])
    f.init()


    eq2 = a + MX(2)
    eq3 = a*b
    eq4 = f.call([a])[0]

    r1 = RealVariable(model, a, Variable.INTERNAL, Variable.PARAMETER)
    r2 = RealVariable(model, b, Variable.INTERNAL, Variable.PARAMETER)
    r3 = RealVariable(model, c, Variable.INTERNAL, Variable.PARAMETER)
    r4 = RealVariable(model, d, Variable.INTERNAL, Variable.PARAMETER)
    r5 = RealVariable(model, e, Variable.INTERNAL, Variable.PARAMETER)

    model.addVariable(r1)
    model.addVariable(r2)
    model.addVariable(r3)
    model.addVariable(r4)
    model.addVariable(r5)

    model.set(["a", "e"], [10, -25])
    r2.setAttribute("bindingExpression", eq2)
    r3.setAttribute("bindingExpression", eq3)
    r4.setAttribute("bindingExpression", eq4)

    varnames = ["a", "b", "c", "d", "e"]
    answers = [10, 12, 120, 20, -25]
    for name, value in zip(varnames, answers):
        assert model.get(name) == value
    assert numpy.array_equal(model.get(["a", "b", "c", "d", "e"]), answers)
    
@testattr(casadi = True)    
def test_DependentParameters_old():
    model = Model()

    a = MX("a")
    b = MX("b")
    c = MX("c")
    d = MX("d")
    funcVar = MX("funcVar")
    f = MXFunction([funcVar], [funcVar*2])
    f.init()


    eq1 = MX(10)
    eq2 = a + MX(2)
    eq3 = a*b
    eq4 = f.call([a])[0]

    r1 = RealVariable(model, a, Variable.INTERNAL, Variable.PARAMETER)
    r2 = RealVariable(model, b, Variable.INTERNAL, Variable.PARAMETER)
    r3 = RealVariable(model, c, Variable.INTERNAL, Variable.PARAMETER)
    r4 = RealVariable(model, d, Variable.INTERNAL, Variable.PARAMETER)

    r1.setAttribute("bindingExpression", eq1)
    r2.setAttribute("bindingExpression", eq2)
    r3.setAttribute("bindingExpression", eq3)
    r4.setAttribute("bindingExpression", eq4)

    model.addVariable(r1)
    model.addVariable(r2)
    model.addVariable(r3)
    model.addVariable(r4)

    model.calculateValuesForDependentParameters()

    assert r2.getAttribute("evaluatedBindingExpression").getValue() == 12
    assert r3.getAttribute("evaluatedBindingExpression").getValue() == 120
    assert r4.getAttribute("evaluatedBindingExpression").getValue() == 20
    
@testattr(casadi = True)    
def test_DisallowedChangedBindingExpression():
    m = Model()
    
    a = MX("a")
    b = MX("b")

    eq1 = MX(10)
    eq2 = a + MX(2)

    r1 = RealVariable(m, a, Variable.INTERNAL, Variable.PARAMETER)
    r2 = RealVariable(m, b, Variable.INTERNAL, Variable.PARAMETER)

    r1.setAttribute("bindingExpression", eq1)
    r2.setAttribute("bindingExpression", eq2)

    errorString = ""

    # Test independent parameter
    # Try to set a new constant bindingExpression, allowed
    r1.setAttribute("bindingExpression", 5)
    assert r1.getAttribute("bindingExpression").getValue() == 5
    # Try to set a non constant bindingExpression
    try:
        r1.setAttribute("bindingExpression", MX("var"))
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "It is not allowed to make independent parameters dependent");

    # Test dependent parameter, no changes to bindingExpression allowed
    # Try to set a constant bindingExpression
    try:
        r2.setAttribute("bindingExpression", 5)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "It is not allowed to change binding expression of dependent parameters");
    # Try to set a non constant bindingExpression
    try:
        r2.setAttribute("bindingExpression", MX("var"))
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "It is not allowed to change binding expression of dependent parameters");
    

@testattr(casadi = True)    
def test_NumericalEvaluation():
    model = Model()

    a = MX("a")
    b = MX("b")
    c = MX("c")
    d = MX("d")
    funcVar = MX("funcVar")
    f = MXFunction([funcVar], [funcVar*2])
    f.init()
    
    eq1 = MX(10)
    eq2 = a + MX(2)
    eq3 = a*b
    eq4 = f.call([a])[0]
    
    r1 = RealVariable(model, a, Variable.INTERNAL, Variable.PARAMETER)
    r2 = RealVariable(model, b, Variable.INTERNAL, Variable.PARAMETER)
    r3 = RealVariable(model, c, Variable.INTERNAL, Variable.PARAMETER)
    r4 = RealVariable(model, d, Variable.INTERNAL, Variable.PARAMETER)
    
    r1.setAttribute("bindingExpression", eq1)
    r2.setAttribute("bindingExpression", eq2)
    r2.setAttribute("max", a * 2);
    r3.setAttribute("bindingExpression", eq3)
    r3.setAttribute("start", b)
    r4.setAttribute("bindingExpression", eq4)
    r4.setAttribute("nominal", c);
    
    model.addVariable(r1)
    model.addVariable(r2)
    model.addVariable(r3)
    model.addVariable(r4)
    
    assert model.evaluateExpression(r2.getAttribute("max")) == 20
    assert model.evaluateExpression(r3.getAttribute("start")) == 12
    assert model.evaluateExpression(r4.getAttribute("nominal")) == 120
    
    # Try to evaluate an expression that can't be evaluated using the information
    # in the Model. 
    import sys
    errorThrown = False # The exception string is platform dependent. 
    try:
        model.evaluateExpression(MX("notInTheModel"))
    except:
        errorThrown = True
    assert errorThrown
    
@testattr(casadi = True)    
def test_equationGetter():
    lhs = MX("lhs")
    rhs = MX("rhs")
    eq = Equation(lhs, rhs)
    assert( isEqual(eq.getLhs(), lhs) )
    assert( isEqual(eq.getRhs(), rhs) )
    assert( isEqual(eq.getResidual(), lhs - rhs) )
    
@testattr(casadi = True)    
def test_equationPrinting(): 
    eq = Equation(MX("lhs"), MX("rhs"));
    assert( str(eq) == "lhs = rhs" );

@testattr(casadi = True)    
def test_RealTypePrinting():
    realType = RealType()
    expectedPrint = ("Real type (displayUnit = , fixed = 0, max = inf, min = -inf, nominal = 1, quantity = , start = 0, unit = );")
    assert( str(realType) == expectedPrint )
    assert( realType.getAttribute("start").getValue() == 0 )
    assert( realType.hasAttribute("quantity") )
    assert( not realType.hasAttribute("not") )
    assert( realType.getName() == "Real" )
    
@testattr(casadi = True)    
def test_VariableDedicatedGettersAndSetters():
    m = Model()
    
    realVar = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)

    quantity = MX("q")
    realVar.setQuantity("q")
    assert str(realVar.getQuantity()) == str(quantity)
    realVar.setQuantity(quantity)
    assert quantity.isEqual(realVar.getQuantity())

    nominal = MX(1)
    realVar.setNominal(1)
    assert str(realVar.getNominal()) == str(nominal)
    realVar.setNominal(nominal)
    assert nominal.isEqual(realVar.getNominal())

    unit = MX("u")
    realVar.setUnit("u")
    assert str(realVar.getUnit()) == str(unit)
    realVar.setUnit(unit)
    assert unit.isEqual(realVar.getUnit())

    displayUnit = MX("du")
    realVar.setDisplayUnit("du")
    assert str(realVar.getDisplayUnit()) == str(displayUnit)
    realVar.setDisplayUnit(displayUnit)
    assert displayUnit.isEqual(realVar.getDisplayUnit())

    min = MX(-1)
    realVar.setMin(-1)
    assert str(realVar.getMin()) == str(min)
    realVar.setMin(min)
    assert min.isEqual(realVar.getMin())

    Max = MX(1)
    realVar.setMax(1)
    assert str(realVar.getMax()) == str(Max)
    realVar.setMax(Max)
    assert Max.isEqual(realVar.getMax())

    Start = MX(1)
    realVar.setStart(1)
    assert str(realVar.getStart()) == str(Start)
    realVar.setStart(Start)
    assert Start.isEqual(realVar.getStart())

    fixed = MX(False)
    realVar.setFixed(False)
    assert str(realVar.getFixed()) == str(fixed)
    realVar.setFixed(fixed)
    assert fixed.isEqual(realVar.getFixed())

    
    
@testattr(casadi = True)    
def test_RealVariableAttributes():
    m = Model()
    
    attributeNode1 = MX(1)
    attributeNode2 = MX(2)
    realVar = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)

    realVar.setAttribute("myAttribute", attributeNode1)
    assert( isEqual(realVar.getAttribute("myAttribute"), attributeNode1) )
    realVar.setAttribute("myAttribute", attributeNode2)
    assert( isEqual(realVar.getAttribute("myAttribute"), attributeNode2) )
    assert( realVar.hasAttributeSet("myAttribute"))
    assert( not realVar.hasAttributeSet("iDontHaveThisAttribute"))
    assert( realVar.getName() == "node" )
    realVar.setAttribute("start", 1)
    assert( abs(realVar.getAttribute("start").getValue() - 1) < 0.000001)

@testattr(casadi = True)    
def test_RealVariableConstants():
    m = Model()
    
    realVar = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)
    assert( realVar.getCausality() == Variable.INTERNAL )
    assert( realVar.getVariability() == Variable.CONTINUOUS )
    assert( realVar.getType() == Variable.REAL)
    assert( not realVar.isDerivative() )
    
@testattr(casadi = True)    
def test_RealVariableNode():
    m = Model()

    node = MX("var")
    realVar = RealVariable(m, node, Variable.INTERNAL, Variable.CONTINUOUS)
    assert( isEqual(realVar.getVar(), node) )
    
@testattr(casadi = True)    
def test_RealVariableVariableType():
    m = Model()

    realVar = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)
    assert( realVar.getDeclaredType() == None )
    realType = RealType()
    realVar.setDeclaredType(realType)
    # Has attribute looks at the variable. getAttribute gets the attribute even if it is in 
    # the declared type. 
    assert( (not realVar.hasAttributeSet("nominal")) and (realVar.getAttribute("nominal") is not None)) 
    assert( int(realType.this) == int(realVar.getDeclaredType().this) )
    userType = UserType("typeName", realType)
    realVar.setDeclaredType(userType)
    assert( int(userType.this) == int(realVar.getDeclaredType().this) )
    
@testattr(casadi = True)    
def test_RealVariableDerivativeVariable():
    m = Model()

    realVar = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)
    derVar = DerivativeVariable(m, MX("node"), realVar)
    assert( realVar.getMyDerivativeVariable() == None )
    realVar.setMyDerivativeVariable(derVar)
    assert( int(realVar.getMyDerivativeVariable().this) == int(derVar.this) )

@testattr(casadi = True)    
def test_RealVariableNonSymbolicError():
    import sys

    m = Model()
    
    errorString = ""
    try:
        realVar = RealVariable(m, MX(1), Variable.INTERNAL, Variable.CONTINUOUS)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "A variable must have a symbolic MX");
    
@testattr(casadi = True)    
def test_RealVariableInvalidDerivativeVariable():
    import sys

    m = Model()
    
    realVar1 = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar2 = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)
    notARealVariable = IntegerVariable(m, MX("node"), Variable.INPUT, Variable.DISCRETE)
    errorString = ""
    try:
        realVar1.setMyDerivativeVariable(notARealVariable)
    except:
        errorString = sys.exc_info()[1].message 
    print errorString
    assert(errorString == "A Variable that is set as a derivative variable must be a DerivativeVariable");
    
    errorString = ""
    try:
        realVar1.setMyDerivativeVariable(realVar2)
    except:
        errorString = sys.exc_info()[1].message 
    print errorString
    assert(errorString == "A Variable that is set as a derivative variable must be a DerivativeVariable");
    
@testattr(casadi = True)    
def test_RealVariableInvalidAsStateVariable():
    import sys

    m = Model()
    
    realVar = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)
    derVar = DerivativeVariable(m, MX("node"), None)
    
    errorString = ""
    try:
        realVar.setMyDerivativeVariable(derVar)
    except:
        errorString = sys.exc_info()[1].message 
    print errorString
    assert(errorString == "A RealVariable that is a state variable must have continuous variability, and may not be a derivative variable.");
    
@testattr(casadi = True)    
def test_RealVariablePrinting():
    m = Model()
    
    realVar = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar.setAttribute("myAttribute", MX(2))
    assert( str(realVar) == "Real node(myAttribute = 2);" );
    
@testattr(casadi = True)    
def test_DerivativeVariableAttributes():
    m = Model()

    attributeNode1 = MX(1)
    attributeNode2 = MX(2)
    derVar = DerivativeVariable(m, MX("node"), None)

    derVar.setAttribute("myAttribute", attributeNode1)
    assert( isEqual(derVar.getAttribute("myAttribute"), attributeNode1) )
    derVar.setAttribute("myAttribute", attributeNode2)
    assert( isEqual(derVar.getAttribute("myAttribute"), attributeNode2) )
    assert( derVar.hasAttributeSet("myAttribute"))
    assert( not derVar.hasAttributeSet("iDontHaveThisAttribute"))
    assert( derVar.getName() == "node" )

@testattr(casadi = True)    
def test_DerivativeVariableConstants():
    m = Model()

    derVar = DerivativeVariable(m, MX("node"), None)
    assert( derVar.getCausality() == Variable.INTERNAL )
    assert( derVar.getVariability() == Variable.CONTINUOUS )
    assert( derVar.getType() == Variable.REAL)
    assert( derVar.isDerivative() )

@testattr(casadi = True)    
def test_DerivativeVariableNode():
    m = Model()

    node = MX("var")
    derVar = DerivativeVariable(m, node, None)
    assert( isEqual(derVar.getVar(), node) )
    
@testattr(casadi = True)    
def test_DerivativeVariableVariableType():
    m = Model()

    derVar = DerivativeVariable(m, MX("node"), None)
    assert( derVar.getDeclaredType() == None )
    realType = RealType()
    derVar.setDeclaredType(realType)
    assert( int(realType.this) == int(derVar.getDeclaredType().this) )
    userType = UserType("typeName", realType)
    derVar.setDeclaredType(userType)
    assert( int(userType.this) == int(derVar.getDeclaredType().this) )
    
@testattr(casadi = True)    
def test_DerivativeVariableDifferentiatedVariable():
    m = Model()
    
    realVar = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)
    derVar = DerivativeVariable(m, MX("node"), realVar)
    #assert( int(derVar.getMyDifferentiatedVariable().this) == int(realVar.this) )

@testattr(casadi = True)    
def test_DerivativeVariableInvalidStateVariable():
    import sys

    m = Model()
    
    realVar = RealVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)
    intVar = IntegerVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)
    
    errorString = ""
    try:
        derVar = DerivativeVariable(m, MX("node"), realVar)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "A state variable must have real type and continuous variability");
    errorString = ""
    try:
        derVar = DerivativeVariable(m, MX("node"), intVar)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "A state variable must have real type and continuous variability");

@testattr(casadi = True)    
def test_DerivativeVariablePrinting():
    m = Model()
    
    derVar = DerivativeVariable(m, MX("node"), None)
    derVar.setAttribute("myAttribute", MX(2))
    assert( str(derVar) == "Real node(myAttribute = 2);" )

@testattr(casadi = True)    
def test_IntegerVariableAttributes():
    m = Model()
    
    attributeNode1 = MX(1)
    attributeNode2 = MX(2)
    intVar = IntegerVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)

    intVar.setAttribute("myAttribute", attributeNode1)
    assert( isEqual(intVar.getAttribute("myAttribute"), attributeNode1) )
    intVar.setAttribute("myAttribute", attributeNode2)
    assert( isEqual(intVar.getAttribute("myAttribute"), attributeNode2) )
    assert( intVar.hasAttributeSet("myAttribute"))
    assert( not intVar.hasAttributeSet("iDontHaveThisAttribute"))
    assert( intVar.getName() == "node")
    
@testattr(casadi = True)    
def test_IntegerVariableConstants():
    m = Model()
    
    intVar = IntegerVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)
    assert( intVar.getCausality() == Variable.INTERNAL )
    assert( intVar.getVariability() == Variable.DISCRETE )
    assert( intVar.getType() == Variable.INTEGER)

@testattr(casadi = True)    
def test_IntegerVariableNode():
    m = Model()
    
    node = MX("var")
    intVar = IntegerVariable(m, node, Variable.INTERNAL, Variable.DISCRETE)
    assert( isEqual(intVar.getVar(), node) )
    
@testattr(casadi = True)    
def test_IntegerVariableVariableType():
    m = Model()
    
    intVar = IntegerVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)
    assert( intVar.getDeclaredType() == None )
    intType = IntegerType()
    intVar.setDeclaredType(intType)
    assert( int(intType.this) == int(intVar.getDeclaredType().this) )
    userType = UserType("typeName", intType)
    intVar.setDeclaredType(userType)
    assert( int(userType.this) == int(intVar.getDeclaredType().this) )
   
@testattr(casadi = True)    
def test_IntegerVariablePrinting():
    m = Model()
    
    intVar = IntegerVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)
    intVar.setAttribute("myAttribute", MX(2))
    assert( str(intVar) == "discrete Integer node(myAttribute = 2);" )
    
@testattr(casadi = True)    
def test_IntegerVariableContinuousError():
    import sys

    m = Model()
    
    errorString = ""
    try:
        intVar = IntegerVariable(m, MX("var"), Variable.INTERNAL, Variable.CONTINUOUS)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "An integer variable can not have continuous variability");
    
@testattr(casadi = True)    
def test_BooleanVariableAttributes():
    m = Model()
    
    attributeNode1 = MX(1)
    attributeNode2 = MX(2)
    boolVar = BooleanVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)

    boolVar.setAttribute("myAttribute", attributeNode1)
    assert( isEqual(boolVar.getAttribute("myAttribute"), attributeNode1) )
    boolVar.setAttribute("myAttribute", attributeNode2)
    assert( isEqual(boolVar.getAttribute("myAttribute"), attributeNode2) )
    assert( boolVar.hasAttributeSet("myAttribute"))
    assert( not boolVar.hasAttributeSet("iDontHaveThisAttribute"))
    assert( boolVar.getName() == "node")
    
@testattr(casadi = True)    
def test_BooleanVariableConstants():
    m = Model()
    
    boolVar = BooleanVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)
    assert( boolVar.getCausality() == Variable.INTERNAL )
    assert( boolVar.getVariability() == Variable.DISCRETE )
    assert( boolVar.getType() == Variable.BOOLEAN)

@testattr(casadi = True)    
def test_BooleanVariableNode():
    m = Model()
    
    node = MX("var")
    boolVar = BooleanVariable(m, node, Variable.INTERNAL, Variable.DISCRETE)
    assert( isEqual(boolVar.getVar(), node) )
    
@testattr(casadi = True)    
def test_BooleanVariableVariableType():
    m = Model()
    
    boolVar = BooleanVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)
    assert( boolVar.getDeclaredType() == None )
    boolType = BooleanType()
    boolVar.setDeclaredType(boolType)
    assert( int(boolType.this) == int(boolVar.getDeclaredType().this) )
    userType = UserType("typeName", boolType)
    boolVar.setDeclaredType(userType)
    assert( int(userType.this) == int(boolVar.getDeclaredType().this) )
    
@testattr(casadi = True)    
def test_BooleanVariableContinuousError():
    import sys

    m = Model()
    
    errorString = ""
    try:
        boolVar = BooleanVariable(m, MX("var"), Variable.INTERNAL, Variable.CONTINUOUS)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "A boolean variable can not have continuous variability");
    
@testattr(casadi = True)    
def test_BooleanVariablePrinting():
    m = Model()
    
    boolVar = BooleanVariable(m, MX("node"), Variable.INTERNAL, Variable.DISCRETE)
    boolVar.setAttribute("myAttribute", MX(2))
    assert( str(boolVar) == "discrete Boolean node(myAttribute = 2);" )
    
@testattr(casadi = True)    
def test_TimedVariable():
    opt = OptimizationProblem()
    
    realVar = RealVariable(opt, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)
    timePoint = MX("ATimePointExpression")
    node = MX("node")
    timedVar = TimedVariable(opt, node, realVar, timePoint)
    assert realVar == timedVar.getBaseVariable()
    assert node.isEqual(timedVar.getVar())
    assert timePoint.isEqual(timedVar.getTimePoint())
    

@testattr(casadi = True)    
def test_TimedVariableInvalidBaseVarType():
    opt = OptimizationProblem()
    
    boolVar = BooleanVariable(opt, MX("node"), Variable.INTERNAL, Variable.DISCRETE)
    try:
        timedVar = TimedVariable(opt, MX("var"), boolVar, MX("ATimePointExpression"))
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "Timed variables only supported for real variables");
    
    
@testattr(casadi = True)    
def test_ModelFunctionGetName():
    funcVar = MX("node")
    functionName = "myFunction"
    function = MXFunction([funcVar],[funcVar+2])
    function.setOption("name", functionName)
    function.init()
    modelFunction = ModelFunction(function)
    assert( modelFunction.getName() == functionName )

@testattr(casadi = True)    
def test_ModelFunctionGetNameCall():
    funcVar = MX("node")
    functionName = "myFunction"
    function = MXFunction([funcVar],[funcVar+2])
    function.setOption("name", functionName)
    function.init()
    modelFunction = ModelFunction(function)
    arg = MX("arg")
    argVec = MXVector()
    argVec.append(arg)
    manualCall = function.call(argVec)[0]
    mfCall = modelFunction.call(argVec)
    assert( isEqual( mfCall[0].getDep(0).getDep(0),arg) )
    assert( str(manualCall) == str(mfCall[0]) )

@testattr(casadi = True)    
def test_ModelFunctionCallAndUse():
    funcVar = MX("node")
    functionName = "myFunction"
    function = MXFunction([funcVar],[funcVar+2])
    function.setOption("name", functionName)
    function.init()
    modelFunction = ModelFunction(function)
    arg = MX("arg")
    argVec = MXVector()
    argVec.append(arg)
    call = modelFunction.call(argVec)
    evaluateCall = MXFunction([arg], [call[0]])
    evaluateCall.init()
    evaluateCall.setInput(0.0)
    evaluateCall.evaluate()        
    assert( evaluateCall.output().elem(0) == 2 )
    
@testattr(casadi = True)    
def test_ModelFunctionPrinting():
    funcVar = MX("node")
    functionName = "myFunction"
    function = MXFunction([funcVar],[funcVar+2])
    function.setOption("name", functionName)
    function.init()
    modelFunction = ModelFunction(function)
    expectedPrint = ("ModelFunction : function(\"myFunction\")\n" +
                    " Input: 1-by-1 (dense)\n" +
                    " Output: 1-by-1 (dense)\n" +
                    "@0 = 2\n" +
                    "@1 = input[0]\n" +
                    "@0 = (@0+@1)\n" +
                    "output[0] = @0\n")
    assert( str(modelFunction) == expectedPrint )

@testattr(casadi = True)    
def test_Constraint():
    lhs = MX("lhs")
    rhs = MX("rhs")
    equalityConstraint = Constraint(lhs, rhs, Constraint.EQ)
    lessThanConstraint = Constraint(lhs, rhs, Constraint.LEQ)
    greaterThanConstraint = Constraint(lhs, rhs, Constraint.GEQ)
    
    # Equality constraint
    assert( isEqual(equalityConstraint.getLhs(), lhs) )
    assert( isEqual(equalityConstraint.getRhs(), rhs) )
    assert( isEqual(equalityConstraint.getResidual(), lhs - rhs) )
    assert( equalityConstraint.getType() == Constraint.EQ)
    # Less than or equal to constraint
    assert( isEqual(lessThanConstraint.getLhs(), lhs) )
    assert( isEqual(lessThanConstraint.getRhs(), rhs) )
    assert( isEqual(equalityConstraint.getResidual(), lhs - rhs) )
    assert( lessThanConstraint.getType() == Constraint.LEQ )
    # Greater than or equal to constraint
    assert( isEqual(greaterThanConstraint.getLhs(), lhs) )
    assert( isEqual(greaterThanConstraint.getRhs(), rhs) )
    assert( isEqual(greaterThanConstraint.getResidual(), lhs - rhs) )
    assert( greaterThanConstraint.getType() == Constraint.GEQ )

@testattr(casadi = True)    
def test_ConstraintPrinting():
    lhs = MX("lhs")
    rhs = MX("rhs")
    equalityConstraint = Constraint(lhs, rhs, Constraint.EQ)
    lessThanConstraint = Constraint(lhs, rhs, Constraint.LEQ)
    greaterThanConstraint = Constraint(lhs, rhs, Constraint.GEQ)
    actual = str(equalityConstraint) + str(lessThanConstraint) + str(greaterThanConstraint)
    assert( actual == "lhs = rhslhs <= rhslhs >= rhs" )


@testattr(casadi = True)    
def test_OptimizationProblemTime():
    start = MX (0)
    final = MX(1)
    opt = OptimizationProblem()
    
    assert( opt.getStartTime().isNull() )
    assert( opt.getFinalTime().isNull() )
    opt.setStartTime(start)
    opt.setFinalTime(final)
    assert( isEqual(start, opt.getStartTime()) )
    assert( isEqual(final, opt.getFinalTime()) )
    
@testattr(casadi = True)    
def test_OptimizationProblemLagrangeMayer():
    lagrange = MX("lagrange")
    mayer = MX("mayer")
    opt = OptimizationProblem()

    assert( opt.getObjectiveIntegrand().isNull() )
    assert( opt.getObjective().isNull() )
    
    opt.setObjective(mayer)
    opt.setObjectiveIntegrand(lagrange)
    
    assert( isEqual(lagrange, opt.getObjectiveIntegrand()) )
    assert( isEqual(mayer, opt.getObjective()) )

@testattr(casadi = True)    
def test_OptimizationProblemPathConstraints():
    constraintsLessThan = numpy.array([], dtype = object)
    constraintsGreaterThan = numpy.array([], dtype = object)
    lhs = MX("lhs")
    rhs = MX("rhs")
    lessThanConstraint = Constraint(lhs, rhs, Constraint.LEQ)
    greaterThanConstraint = Constraint(lhs, rhs, Constraint.GEQ)
    constraintsLessThan = numpy.append(constraintsLessThan, lessThanConstraint)
    constraintsGreaterThan = numpy.append(constraintsGreaterThan, greaterThanConstraint)

    opt = OptimizationProblem()
    
    assert( len(opt.getPathConstraints()) == 0 )
    opt.setPathConstraints(constraintsLessThan)
    assert( isEqual(opt.getPathConstraints()[0].getResidual(), lessThanConstraint.getResidual()) )
    
    opt.setPathConstraints(constraintsGreaterThan)
    assert( isEqual(opt.getPathConstraints()[0].getResidual(), greaterThanConstraint.getResidual()) )
    assert( len(opt.getPathConstraints()) == 1)
    
@testattr(casadi = True)    
def test_OptimizationProblemPointConstraints():
    constraintsLessThan = numpy.array([], dtype = object)
    constraintsGreaterThan = numpy.array([], dtype = object)
    lhs = MX("lhs")
    rhs = MX("rhs")
    lessThanConstraint = Constraint(lhs, rhs, Constraint.LEQ)
    greaterThanConstraint = Constraint(lhs, rhs, Constraint.GEQ)
    constraintsLessThan = numpy.append(constraintsLessThan, lessThanConstraint)
    constraintsGreaterThan = numpy.append(constraintsGreaterThan, greaterThanConstraint)

    opt = OptimizationProblem()
    
    assert( len(opt.getPointConstraints()) == 0 )
    opt.setPointConstraints(constraintsLessThan)
    assert( isEqual(opt.getPointConstraints()[0].getResidual(), lessThanConstraint.getResidual()) )
    
    opt.setPointConstraints(constraintsGreaterThan)
    assert( isEqual(opt.getPointConstraints()[0].getResidual(), greaterThanConstraint.getResidual()) )
    assert( len(opt.getPointConstraints()) == 1)
    
@testattr(casadi = True)    
def test_OptimizationProblemTimedVariables():
    optTimedVars = OptimizationProblem()
    
    realVar1 = RealVariable(optTimedVars, MX("node1"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar2 = RealVariable(optTimedVars, MX("node2"), Variable.INTERNAL, Variable.CONTINUOUS)

    t1 = TimedVariable(optTimedVars, MX("node1AtSomeTime"), realVar1, MX("someTime"))
    t2 = TimedVariable(optTimedVars, MX("node2AtSomeTime"), realVar2, MX("someOtherTime"))


    assert( len(optTimedVars.getTimedVariables()) == 0)
    optTimedVars.addTimedVariable(t1)
    optTimedVars.addTimedVariable(t2)
    timedVarsFromModel = optTimedVars.getTimedVariables();

    assert( len(timedVarsFromModel) == 2 )
    assert( isEqual(t1.getVar(), timedVarsFromModel[0].getVar()) )
    assert( isEqual(t2.getVar(), timedVarsFromModel[1].getVar()) )
    assert( isEqual(realVar1.getVar(), timedVarsFromModel[0].getBaseVariable().getVar()) )
    assert( isEqual(realVar2.getVar(), timedVarsFromModel[1].getBaseVariable().getVar()) )
    
@testattr(casadi = True)    
def test_OptimizationProblemPrinting():
    simpleOptProblem = OptimizationProblem()
    expectedPrint = ("Model contained in OptimizationProblem:\n\n" +
                     "------------------------------- Variables -------------------------------\n\n\n" +
                     "---------------------------- Variable types  ----------------------------\n\n\n" +
                     "------------------------------- Functions -------------------------------\n\n\n" +
                     "------------------------------- Equations -------------------------------\n\n\n" +
                     "----------------------- Optimization information ------------------------\n\n" +
                     "Start time = not set\nFinal time = not set\n\n\n" +
                     "-- Objective integrand term --\nnot set\n-- Objective term --\nnot set")
    print simpleOptProblem
    assert( str(simpleOptProblem) == expectedPrint )

@testattr(casadi = True)    
def test_ModelVariableKindsEmpty():
    model = Model()
    for kind in range(Model.NUM_OF_VARIABLE_KIND):
        assert( len(model.getVariables(kind)) == 0)

@testattr(casadi = True)    
def test_ModelVariableSorting():
    model = Model()
    var1 = MX("node1")
    var2 = MX("node2")

    def checkVariablesEqualToInOrder(varTuple, varVec):
        for i in range(len(varTuple)):
            assert( int(varTuple[i].this) == int(varVec[i].this))
    def addVariableVectorToModel(varVec, model):
        for i in range(len(varVec)):
            model.addVariable(varVec[i])

    #Create different kinds of variables
    inputRealVariables = numpy.array([], dtype = object)
    inputIntegerVariables = numpy.array([], dtype = object)
    inputBooleanVariables = numpy.array([], dtype = object)
    algebraicVariables = numpy.array([], dtype = object)
    differentiatedVariables = numpy.array([], dtype = object)
    derivativeVariables = numpy.array([], dtype = object)
    discreteRealVariables = numpy.array([], dtype = object)
    discreteIntegerVariables = numpy.array([], dtype = object)
    discreteBooleanVariables = numpy.array([], dtype = object)
    constantRealVariables = numpy.array([], dtype = object)
    constantIntegerVariables = numpy.array([], dtype = object)
    constantBooleanVariables = numpy.array([], dtype = object)
    indepenentRealParameterVariables = numpy.array([], dtype = object)
    depenentRealParameterVariables = numpy.array([], dtype = object)
    indepenentIntegerParameterVariables = numpy.array([], dtype = object)
    depenentIntegerParameterVariables = numpy.array([], dtype = object)
    indepenentBooleanParameterVariables = numpy.array([], dtype = object)
    depenentBooleanParameterVariables = numpy.array([], dtype = object)

    # Real variables
    rIn1 = RealVariable(model, var1, Variable.INPUT, Variable.CONTINUOUS)
    rIn2 = RealVariable(model, var1, Variable.INPUT, Variable.DISCRETE)
    rIn3 = RealVariable(model, var1, Variable.INPUT, Variable.PARAMETER)
    rIn4 = RealVariable(model, var1, Variable.INPUT, Variable.CONSTANT)
    inputRealVariables = numpy.append(inputRealVariables, [rIn1, rIn2, rIn3, rIn4])

    rAlg = RealVariable(model, var1, Variable.INTERNAL, Variable.CONTINUOUS)
    rAlgOut = RealVariable(model, var1, Variable.OUTPUT, Variable.CONTINUOUS)
    algebraicVariables = numpy.append(algebraicVariables, [rAlg, rAlgOut])

    rDiff = RealVariable(model, var1, Variable.INTERNAL, Variable.CONTINUOUS)
    rDiffOut = RealVariable(model, var1, Variable.OUTPUT, Variable.CONTINUOUS)
    differentiatedVariables = numpy.append(differentiatedVariables, [rDiff, rDiffOut])
    rDer = DerivativeVariable(model, var1, rDiff)
    rDer2 = DerivativeVariable(model, var1, rDiffOut)
    derivativeVariables = numpy.append(derivativeVariables, [rDer, rDer2])
    rDisc = RealVariable(model, var1, Variable.INTERNAL, Variable.DISCRETE)
    rDiscOut = RealVariable(model, var1, Variable.OUTPUT, Variable.DISCRETE)
    discreteRealVariables = numpy.append(discreteRealVariables, [rDisc, rDiscOut])
    rConst = RealVariable(model, var1, Variable.INTERNAL, Variable.CONSTANT)
    rConstOut = RealVariable(model, var1, Variable.OUTPUT, Variable.CONSTANT)
    constantRealVariables = numpy.append(constantRealVariables, [rConst, rConstOut])
    rIndep = RealVariable(model, var1, Variable.INTERNAL, Variable.PARAMETER)
    rIndepOut = RealVariable(model, var1, Variable.OUTPUT, Variable.PARAMETER)
    indepenentRealParameterVariables = numpy.append(indepenentRealParameterVariables, [rIndep, rIndepOut])
    rDep = RealVariable(model, var1, Variable.INTERNAL, Variable.PARAMETER)
    rDepOut = RealVariable(model, var1, Variable.OUTPUT, Variable.PARAMETER)
    rDep.setAttribute("bindingExpression", var2)
    rDepOut.setAttribute("bindingExpression", var2)
    depenentRealParameterVariables = numpy.append(depenentRealParameterVariables, [rDep, rDepOut])


    # Integer variables
    iIn1 = IntegerVariable(model, var1, Variable.INPUT, Variable.DISCRETE)
    iIn2 = IntegerVariable(model, var1, Variable.INPUT, Variable.PARAMETER)
    iIn3 = IntegerVariable(model, var1, Variable.INPUT, Variable.CONSTANT)
    inputIntegerVariables = numpy.append(inputIntegerVariables, [iIn1, iIn2, iIn3])

    iDisc = IntegerVariable(model, var1, Variable.INTERNAL, Variable.DISCRETE)
    iDiscOut = IntegerVariable(model, var1, Variable.OUTPUT, Variable.DISCRETE)
    discreteIntegerVariables = numpy.append(discreteIntegerVariables, [iDisc, iDiscOut])
    iConst = IntegerVariable(model, var1, Variable.INTERNAL, Variable.CONSTANT)
    iConstOut = IntegerVariable(model, var1, Variable.OUTPUT, Variable.CONSTANT)
    constantIntegerVariables = numpy.append(constantIntegerVariables, [iConst, iConstOut])
    iIndep = IntegerVariable(model, var1, Variable.INTERNAL, Variable.PARAMETER)
    iIndepOut = IntegerVariable(model, var1, Variable.OUTPUT, Variable.PARAMETER)
    indepenentIntegerParameterVariables = numpy.append(indepenentIntegerParameterVariables, [iIndep, iIndepOut])
    iDep = IntegerVariable(model, var1, Variable.INTERNAL, Variable.PARAMETER)
    iDepOut = IntegerVariable(model, var1, Variable.OUTPUT, Variable.PARAMETER)
    iDep.setAttribute("bindingExpression", var2)
    iDepOut.setAttribute("bindingExpression", var2)
    depenentIntegerParameterVariables = numpy.append(depenentIntegerParameterVariables, [iDep, iDepOut])


    # Boolean variables
    bIn1 = BooleanVariable(model, var1, Variable.INPUT, Variable.DISCRETE)
    bIn2 = BooleanVariable(model, var1, Variable.INPUT, Variable.PARAMETER)
    bIn3 = BooleanVariable(model, var1, Variable.INPUT, Variable.CONSTANT)
    inputBooleanVariables = numpy.append(inputBooleanVariables, [bIn1, bIn2, bIn3])

    bDisc = BooleanVariable(model, var1, Variable.INTERNAL, Variable.DISCRETE)
    bDiscOut = BooleanVariable(model, var1, Variable.OUTPUT, Variable.DISCRETE)
    bConst = BooleanVariable(model, var1, Variable.INTERNAL, Variable.CONSTANT)
    bConstOut = BooleanVariable(model, var1, Variable.OUTPUT, Variable.CONSTANT)
    discreteBooleanVariables = numpy.append(discreteBooleanVariables, [bDisc, bDiscOut])
    constantBooleanVariables = numpy.append(constantBooleanVariables, [bConst, bConstOut])
    bIndep = BooleanVariable(model, var1, Variable.INTERNAL, Variable.PARAMETER)
    bIndepOut = BooleanVariable(model, var1, Variable.OUTPUT, Variable.PARAMETER)
    bDep = BooleanVariable(model, var1, Variable.INTERNAL, Variable.PARAMETER)
    bDepOut = BooleanVariable(model, var1, Variable.OUTPUT, Variable.PARAMETER)
    indepenentBooleanParameterVariables = numpy.append(indepenentBooleanParameterVariables, [bIndep, bIndepOut])
    bDep.setAttribute("bindingExpression", var2)
    bDepOut.setAttribute("bindingExpression", var2)
    depenentBooleanParameterVariables = numpy.append(depenentBooleanParameterVariables, [bDep, bDepOut])




    # Add differentiated variable, but without its corresponding derivative variable
    # => should be sorted as algebraic. Then add derivative variable and check again
    addVariableVectorToModel(differentiatedVariables, model)
    checkVariablesEqualToInOrder(model.getVariables(Model.REAL_ALGEBRAIC), differentiatedVariables)
    addVariableVectorToModel(derivativeVariables, model)
    checkVariablesEqualToInOrder(model.getVariables(Model.DIFFERENTIATED), differentiatedVariables) 
    checkVariablesEqualToInOrder(model.getVariables(Model.DERIVATIVE), derivativeVariables) 

    # Add the rest of the variables and check that they are sorted correctly
    addVariableVectorToModel(inputRealVariables, model)
    addVariableVectorToModel(inputIntegerVariables, model)
    addVariableVectorToModel(inputBooleanVariables, model)
    addVariableVectorToModel(algebraicVariables, model)
    addVariableVectorToModel(discreteRealVariables, model)
    addVariableVectorToModel(discreteIntegerVariables, model)
    addVariableVectorToModel(discreteBooleanVariables, model)
    addVariableVectorToModel(constantRealVariables, model)
    addVariableVectorToModel(constantIntegerVariables, model)
    addVariableVectorToModel(constantBooleanVariables, model)
    addVariableVectorToModel(indepenentRealParameterVariables, model)
    addVariableVectorToModel(indepenentIntegerParameterVariables, model)
    addVariableVectorToModel(indepenentBooleanParameterVariables, model)
    addVariableVectorToModel(depenentRealParameterVariables, model)
    addVariableVectorToModel(depenentIntegerParameterVariables, model)
    addVariableVectorToModel(depenentBooleanParameterVariables, model)
    checkVariablesEqualToInOrder(model.getVariables(Model.REAL_INPUT), inputRealVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.INTEGER_INPUT), inputIntegerVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.BOOLEAN_INPUT), inputBooleanVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.REAL_ALGEBRAIC), algebraicVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.DIFFERENTIATED), differentiatedVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.DERIVATIVE), derivativeVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.REAL_DISCRETE), discreteRealVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.INTEGER_DISCRETE), discreteIntegerVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.BOOLEAN_DISCRETE), discreteBooleanVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.REAL_CONSTANT), constantRealVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.INTEGER_CONSTANT), constantIntegerVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.BOOLEAN_CONSTANT), constantBooleanVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.REAL_PARAMETER_INDEPENDENT), indepenentRealParameterVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.INTEGER_PARAMETER_INDEPENDENT), indepenentIntegerParameterVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.BOOLEAN_PARAMETER_INDEPENDENT), indepenentBooleanParameterVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.REAL_PARAMETER_DEPENDENT), depenentRealParameterVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.INTEGER_PARAMETER_DEPENDENT), depenentIntegerParameterVariables)
    checkVariablesEqualToInOrder(model.getVariables(Model.BOOLEAN_PARAMETER_DEPENDENT), depenentBooleanParameterVariables)

@testattr(casadi = True)    
def test_ModelEqutionFunctionality():
    model = Model()
    var1 = MX("var1")
    var2 = MX("var2")
    var3 = MX("var3")
    var4 = MX("var4")
    res1 = var1 - var2
    res2 = var3 - var4
    eq1 = Equation(var1, var2)
    eq2 = Equation(var3, var4)

    # Should return an MX with a null node (default MX value 
    # for default/empty constructor), if there are no equations
    assert( model.getDaeResidual().isNull() )
     # Add equations and check residuals
    model.addDaeEquation(eq1)
    model.addDaeEquation(eq2)
    model.addInitialEquation(eq1)
    assert( isEqual(res1, model.getInitialResidual()) )
    # Also test residuals with more than one residual equation
    res1.append(res2)
    # isEqual in the casadi namespace gives a false negative 
    # (which is warned for in the casadi source) if used, 
    # so MX.isEqual is used instead.
    assert( res1.isEqual(model.getDaeResidual(), 2) )

@testattr(casadi = True)    
def test_ModelWithModelFunction():
    model = Model()
    funcVar = MX("node")
    functionName = "myFunction"
    f = MXFunction([funcVar],[funcVar+2])
    f.setOption("name", functionName)
    f.init()
    modelFunction = ModelFunction(f)
    assert( model.getModelFunction(functionName) == None )
    model.setModelFunctionByItsName(modelFunction)
    assert( int(model.getModelFunction(functionName).this) == int(modelFunction.this) )
    assert( model.getModelFunction("iDontExist") == None )

@testattr(casadi = True)    
def test_ModelNonExistingVariableType():
    model = Model()
    assert( model.getVariableType("IAmNotATypeInModel") == None )
    
@testattr(casadi = True)    
def test_ModelDefaultVariableTypeAssignment():
    model = Model()
    realVar = RealVariable(model, MX("var"), Variable.INTERNAL, Variable.CONTINUOUS)
    model.addVariable(realVar)
    expectedPrint = ("Real type (displayUnit = , fixed = 0, max = inf, min = -inf, nominal = 1, quantity = , start = 0, unit = );")
    assert( str(model.getVariableType("Real")) == expectedPrint )
    
@testattr(casadi = True)    
def test_ModelDefaultVariableTypeAssignmentSingletons():
    model = Model()
    realVar1 = RealVariable(model, MX("var"), Variable.INTERNAL, Variable.CONTINUOUS)
    realVar2 = RealVariable(model, MX("var2"), Variable.INTERNAL, Variable.CONTINUOUS)
    intVar1 = IntegerVariable(model, MX("var"), Variable.INTERNAL, Variable.DISCRETE)
    intVar2 = IntegerVariable(model, MX("var2"), Variable.INTERNAL, Variable.DISCRETE)
    boolVar1 = BooleanVariable(model, MX("var"), Variable.INTERNAL, Variable.DISCRETE)
    boolVar2 = BooleanVariable(model, MX("var2"), Variable.INTERNAL, Variable.DISCRETE)
    model.addVariable(realVar1)
    model.addVariable(realVar2)
    model.addVariable(intVar1)
    model.addVariable(intVar2)
    model.addVariable(boolVar1)
    model.addVariable(boolVar2)
    assert( int(realVar1.getDeclaredType().this) == int(realVar2.getDeclaredType().this) ) 
    assert( int(intVar1.getDeclaredType().this) == int(intVar2.getDeclaredType().this) ) 
    assert( int(boolVar1.getDeclaredType().this) == int(boolVar2.getDeclaredType().this) ) 
    
@testattr(casadi = True)    
def test_ModelVariableTypeGettersSetters():
    model = Model()
    realVarType = RealType()
    model.addVariable(RealVariable(model, MX("var"), Variable.INTERNAL, Variable.CONTINUOUS, realVarType))
    assert( int(realVarType.this) == int(model.getVariableType("Real").this) )
    
    boolVarType = BooleanType()
    model.addVariable(BooleanVariable(model, MX("var"), Variable.INTERNAL, Variable.DISCRETE, boolVarType))
    assert( int(boolVarType.this) == int(model.getVariableType("Boolean").this) )
    
    intVarType = IntegerType()
    model.addVariable(IntegerVariable(model, MX("var"), Variable.INTERNAL, Variable.DISCRETE, intVarType))
    assert( int(intVarType.this) == int(model.getVariableType("Integer").this) )
      
@testattr(casadi = True)    
def test_ModelTrySettingExistingVariableType():
    import sys
    model = Model()
    errorMessage = ""
    expectedErrorMessage = ("A VariableType with the same name as a type in the Model can not be " +
                                     "added if those types are not the same object")
    varType1 = RealType()
    varType2 = RealType()
    model.addNewVariableType(varType1)
    try:
        model.addNewVariableType(varType2)
    except:
        errorMessage = sys.exc_info()[1].message 
    assert( errorMessage==expectedErrorMessage )
       
@testattr(casadi = True)    
def test_ModelInvalidVariabilityRealVariable():
    import sys
    errorString = ""
    model = Model()
    realVar = RealVariable(model, MX("var"), Variable.INTERNAL, 10)
    model.addVariable(realVar)
    try:
        model.getVariables(Model.REAL_ALGEBRAIC)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "Invalid variable variability when sorting for internal real variable: Real var;");
    
@testattr(casadi = True)    
def test_ModelInvalidVariabilityIntegerVariable():
    import sys
    errorString = ""
    model = Model()
    intVar = IntegerVariable(model, MX("var"), Variable.INTERNAL, 10)
    model.addVariable(intVar)
    try:
        model.getVariables(Model.INTEGER_DISCRETE)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "Invalid variable variability when sorting for internal integer variable: Integer var;");
    
@testattr(casadi = True)    
def test_ModelInvalidVariabilityBooleanVariable():
    import sys
    errorString = ""
    model = Model()
    boolVar = BooleanVariable(model, MX("var"), Variable.INTERNAL, 10)
    model.addVariable(boolVar)
    try:
        model.getVariables(Model.BOOLEAN_DISCRETE)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "Invalid variable variability when sorting for internal boolean variable: Boolean var;");
    
@testattr(casadi = True)    
def test_ModelInvalidCausalityRealVariable():
    import sys
    errorString = ""
    model = Model()
    realVar = RealVariable(model, MX("var"), 10, 10)
    model.addVariable(realVar)
    try:
        model.getVariables(Model.REAL_ALGEBRAIC)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "Invalid variable causality when sorting for variable: Real var;")
    
@testattr(casadi = True)    
def test_ModelInvalidCausalityIntegerVariable():
    import sys
    errorString = ""
    model = Model()
    intVar = IntegerVariable(model, MX("var"), 10, 10)
    model.addVariable(intVar)
    try:
        model.getVariables(Model.INTEGER_DISCRETE)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "Invalid variable causality when sorting for variable: Integer var;");
    
@testattr(casadi = True)    
def test_ModelInvalidCausalityBooleanVariable():
    import sys
    errorString = ""
    model = Model()
    boolVar = BooleanVariable(model, MX("var"), 10, 10)
    model.addVariable(boolVar)
    try:
        model.getVariables(Model.BOOLEAN_DISCRETE)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "Invalid variable causality when sorting for variable: Boolean var;");
 
@testattr(casadi = True)    
def test_ModelInvalidVariableKindInGetter():
    import sys
    errorString = ""
    model = Model()
    try:
        model.getVariables(-1)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "Invalid VariableKind");
    try:
        model.getVariables(Model.NUM_OF_VARIABLE_KIND)
    except:
        errorString = sys.exc_info()[1].message 
    assert(errorString == "Invalid VariableKind");
        
@testattr(casadi = True)    
def test_ModelPrinting():
    model = Model()
    realVar = RealVariable(model, MX("node"), Variable.INTERNAL, Variable.CONTINUOUS)
    eq1 = Equation(MX("node1"), MX("node2"))
    eq2 = Equation(MX("node3"), MX("node4"))
    model.addVariable(realVar)
    model.addDaeEquation(eq1)
    model.addInitialEquation(eq2)
    expectedPrint = ("------------------------------- Variables -------------------------------\n\n" +
                    "Real node;\n\n" +
                    "---------------------------- Variable types  ----------------------------\n\n" +
                    "Real type (displayUnit = , fixed = 0, max = inf, min = -inf, nominal = 1, quantity = , start = 0, unit = );\n\n" +
                    "------------------------------- Functions -------------------------------\n\n\n" +
                    "------------------------------- Equations -------------------------------\n\n" +
                    " -- Initial equations -- \nnode3 = node4\n -- DAE equations -- \n" +
                    "node1 = node2\n\n")
    print model, expectedPrint
    assert( str(model) == expectedPrint )
