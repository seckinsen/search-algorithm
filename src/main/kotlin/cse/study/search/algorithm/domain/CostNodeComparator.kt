package cse.study.search.algorithm.domain

import cse.study.search.entity.uninformed.CostNode

object CostNodeComparator : Comparator<CostNode> {

    override fun compare(firstNode: CostNode, secondNode: CostNode): Int =
            firstNode.path.cost.compareTo(secondNode.path.cost)

}