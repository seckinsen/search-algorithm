package cse.study.search.entity.uninformed

import java.math.BigDecimal

class CostAdjacent(var target: CostNode, var cost: BigDecimal) {

    override fun toString(): String {
        return "Adjacent(value=${target.value}, cost=$cost)"
    }

}