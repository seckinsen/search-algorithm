package cse.study.search.entity.informed

import java.math.BigDecimal

class AStarAdjacent(var target: AStarNode, var cost: BigDecimal) {

    override fun toString(): String {
        return "Adjacent(value=${target.value}, cost=$cost)"
    }

}