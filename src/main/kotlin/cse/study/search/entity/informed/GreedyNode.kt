package cse.study.search.entity.informed

import java.math.BigDecimal

class GreedyNode @JvmOverloads constructor(val value: Any,
                                           var cost: BigDecimal = BigDecimal.ZERO,
                                           var visited: Boolean = false,
                                           var adjacents: List<GreedyNode> = emptyList(),
                                           var parent: GreedyNode? = null) {

    fun visited() {
        this.visited = true
    }

    override fun toString(): String {
        return "GreedyNode(value=$value, cost=$cost visited=$visited)"
    }

}
