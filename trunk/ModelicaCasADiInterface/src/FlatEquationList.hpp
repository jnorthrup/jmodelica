/*
Copyright (C) 2013 Modelon AB

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

#ifndef _MODELICACASADI_FLAT_EQUATION_LIST
#define _MODELICACASADI_FLAT_EQUATION_LIST

#include <iostream>
#include "casadi/casadi.hpp"
#include "Equation.hpp"
#include "RefCountedNode.hpp"
#include "Ref.hpp"
#include "EquationContainer.hpp"
#include <vector>
#include <map>
#include <string>

namespace ModelicaCasADi 
{
class FlatEquationList : public EquationContainer {
    public:

        const casadi::MX getDaeResidual() const; 
        std::vector< Ref< Equation> > getDaeEquations() const;
        /** @param A pointer to an equation */ 
        virtual void addDaeEquation(Ref<Equation> eq);
        
        MODELICACASADI_SHAREDNODE_CHILD_PUBLIC_DEFS
    private:
        std::vector< Ref<Equation> > daeEquations;
        
};

inline void FlatEquationList::addDaeEquation(Ref<Equation>eq) { daeEquations.push_back(eq); }
inline std::vector< Ref< Equation> > FlatEquationList::getDaeEquations() const { return daeEquations; }

}; // End namespace
#endif