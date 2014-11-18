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

#ifndef _MODELICACASADI_BLTCONTAINER
#define _MODELICACASADI_BLTCONTAINER

#include <iostream>
#include "casadi/casadi.hpp"
#include "Equation.hpp"
#include "RefCountedNode.hpp"
#include "Block.hpp"
#include "Ref.hpp"
#include "EquationContainer.hpp"
#include <vector>
#include <map>
#include <string>

namespace ModelicaCasADi 
{
class BLTContainer: public EquationContainer {
    public:
        /**
        * Check if equations object has a BLT
        * @return A boolean
        */
        virtual bool hasBLT() const;
        /**
        * Give the DAE residual of all equations from BLT.
        * @return An MX
        */
        virtual const casadi::MX getDaeResidual() const; 
        /**
        * Give the list of equations from BLT.
        * @return A std::vector of Equation
        */
        std::vector< Ref< Equation> > getDaeEquations() const;
        
        /** @param A pointer to an equation */ 
        virtual void addDaeEquation(Ref<Equation> eq);
        
        /**************BlockMethods*************/
        /**
        * Add a block to BLT
        * @param A pointer to a Block.
        */
        void addBlock(Ref<Block> block);
        /**
        * Gives the number of blocks of BLT
        * @return An Integer.
        */
        int getNumberOfBlocks() const;
        /**
        * Gives the ith block of BLT
        * @param An Integer
        * @return A pointer to a Block.
        */
        Ref<Block> getBlock(int i) const;
        /***************************************/
        
        /**************AuxiliaryMethods*************/
        /**
        * Print the BLT
        * @param A std::ostream
        * @param A Boolean 
        */
        void printBLT(std::ostream& out, bool with_details=false) const;
        /**
        * Give the list of variables that are eliminable according to BLT information.
        * Eliminable variables are those that have solution in the BLT.
        * @return A std::set of Variable
        */
        std::set<const Variable*> eliminableVariables() const;
        /**
        * Fills a map with variable -> solution from BLT information
        * @param A std::set of Variable
        * @param A reference to a std::map<Variable,MX>
        */
        void getSubstitues(const std::set<const Variable*>& eliminables, std::map<const Variable*,casadi::MX>& storageMap) const;
        
        /**
        * Substitute all variables that have a solution from BLT. 
        * Variables are not eliminated after substitution, it just inline the symbolic solutions.
        */
        void substituteAllEliminables();
        
        /**
        * Delete the symbolic solution of a variable in the BLT.
        * @param A pointer to a Variable
        */
        void removeSolutionOfVariable(const Variable* var);
        /**
        * Substitute variables to the corresponding mapped expression into equations.
        * @param A std::map<Variable,MX>
        */
        void substitute(const std::map<const Variable*,casadi::MX>& substituteMap);
        
        /** @param A CasadiInterface variable pointer */ 
        bool isBLTEliminable(Ref<Variable> var) const;
        /**
        * Substitute variable to the corresponding solution gotten from BLT.
        * After the substitution the solution equation z=f(z) is removed from BLT.
        * @param A pointer to a Variable.
        */
        void eliminateVariables(Ref<Variable> var);
        /**
        * Substitute variable to the corresponding solution gotten from BLT.
        * After the substitution the solution equation z=f(z) is removed from BLT.
        * @param A std::vector of Variable
        */
        void eliminateVariables(std::vector< Ref<Variable> >& vars);
        /*******************************************/
        
        MODELICACASADI_SHAREDNODE_CHILD_PUBLIC_DEFS
        private:       
        std::vector< Ref<Block> > blt;
        
        
};
inline bool BLTContainer::hasBLT() const {return 1;}
inline void BLTContainer::addDaeEquation(Ref<Equation>eq) { 
   Ref<Block> nBlock = new Block();
   nBlock->addEquation(eq,false);
   addBlock(nBlock);
}
inline int BLTContainer::getNumberOfBlocks() const {return blt.size();}
inline void BLTContainer::addBlock(Ref<Block> block){blt.push_back(block);}
inline Ref<Block> BLTContainer::getBlock(int i) const {return blt[i];}
}; // End namespace
#endif