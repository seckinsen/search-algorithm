package cse.study.search.entity.informed

import java.math.BigDecimal

class AStarPath @JvmOverloads constructor(var h: BigDecimal,
                                          var g: BigDecimal = BigDecimal.ZERO,
                                          var f: BigDecimal = BigDecimal.ZERO) {

    override fun toString(): String {
        return "AStarPath(f($f) = h($h) + g($g))"
    }

}