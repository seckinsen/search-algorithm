package cse.study.search.algorithm.domain

import cse.study.search.entity.GreedyNode

object GreedyNodeComparator : Comparator<GreedyNode> {

    override fun compare(firstNode: GreedyNode, secondNode: GreedyNode): Int =
            firstNode.cost.compareTo(secondNode.cost)

}