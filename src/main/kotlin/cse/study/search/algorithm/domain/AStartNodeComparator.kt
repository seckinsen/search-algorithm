package cse.study.search.algorithm.domain

import cse.study.search.entity.informed.AStarNode

object AStartNodeComparator : Comparator<AStarNode> {

    override fun compare(firstNode: AStarNode, secondNode: AStarNode): Int =
            firstNode.path.f.compareTo(secondNode.path.f)

}