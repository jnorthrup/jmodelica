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

#ifndef _MODELICACASADI_BLTHANDLER
#define _MODELICACASADI_BLTHANDLER

#include <iostream>
#include "casadi/casadi.hpp"
#include "Equation.hpp"
#include "RefCountedNode.hpp"
#include "Ref.hpp"
#include <vector>
#include <map>
#include <string>
#include "Block.hpp"

namespace ModelicaCasADi
{
class BLTHandler : public RefCountedNode{
    public:
    
    /**************BlockMethods*************/
    void addBlock(Ref<Block> block);
    int getNumberOfBlocks() const;
    Ref<Block> getBlock(int i) const;
    /***************************************/
    
    /**************AuxiliaryMethods*************/
    void printBLT(std::ostream& out, bool with_details=false) const;
    std::set<const Variable*> eliminatableVariables() const;
    void getSubstitues(const std::set<const Variable*>& eliminateables, std::map<const Variable*,casadi::MX>& storageMap) const;
    
    std::vector< Ref<Equation> > writeEquationsforModel() const;
    void substituteAllEliminateables();
    void removeSolutionOfVariable(const Variable* var);
    void substitute(const std::map<const Variable*,casadi::MX>& substituteMap);
    /*******************************************/
    
    MODELICACASADI_SHAREDNODE_CHILD_PUBLIC_DEFS
    private:
    std::vector< Ref<Block> > blt;
};

inline int BLTHandler::getNumberOfBlocks() const {return blt.size();}
inline Ref<Block> BLTHandler::getBlock(int i) const {return blt[i];}
inline void BLTHandler::addBlock(Ref<Block> block){blt.push_back(block);}
}; // End namespace
#endif