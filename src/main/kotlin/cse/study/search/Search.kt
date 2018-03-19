package cse.study.search

import cse.study.search.entity.uninformed.Adjacent
import cse.study.search.entity.uninformed.CostNode
import cse.study.search.entity.uninformed.CostEdge
import cse.study.search.entity.uninformed.TreeNode
import org.slf4j.LoggerFactory
import java.math.BigDecimal

fun main(args: Array<String>) {

    val log = LoggerFactory.getLogger("Main")

    val nodeA = CostNode("A")
    val nodeB = CostNode("B")
    val nodeC = CostNode("C")
    val nodeD = CostNode("D")
    val nodeE = CostNode("E")
    val nodeF = CostNode("F")
    val nodeG = CostNode("G")
    val nodeH = CostNode("H")
    val nodeI = CostNode("I")
    val nodeJ = CostNode("J")
    val nodeK = CostNode("K")
    val nodeL = CostNode("L")
    val nodeM = CostNode("M")
    val nodeN = CostNode("N")

    nodeA.adjacents = arrayListOf(Adjacent(nodeB, BigDecimal.valueOf(75)),
            Adjacent(nodeD, BigDecimal.valueOf(140)),
            Adjacent(nodeH, BigDecimal.valueOf(118)))

    nodeB.adjacents = arrayListOf(Adjacent(nodeA, BigDecimal.valueOf(75)),
            Adjacent(nodeC, BigDecimal.valueOf(71)))

    nodeC.adjacents = arrayListOf(Adjacent(nodeB, BigDecimal.valueOf(71)),
            Adjacent(nodeD, BigDecimal.valueOf(151)))

    nodeD.adjacents = arrayListOf(Adjacent(nodeA, BigDecimal.valueOf(140)),
            Adjacent(nodeC, BigDecimal.valueOf(151)),
            Adjacent(nodeE, BigDecimal.valueOf(99)),
            Adjacent(nodeF, BigDecimal.valueOf(80)))

    nodeE.adjacents = arrayListOf(Adjacent(nodeD, BigDecimal.valueOf(99)),
            Adjacent(nodeM, BigDecimal.valueOf(211)))

    nodeF.adjacents = arrayListOf(Adjacent(nodeD, BigDecimal.valueOf(80)),
            Adjacent(nodeG, BigDecimal.valueOf(97)),
            Adjacent(nodeL, BigDecimal.valueOf(138)))

    nodeG.adjacents = arrayListOf(Adjacent(nodeF, BigDecimal.valueOf(97)),
            Adjacent(nodeL, BigDecimal.valueOf(101)),
            Adjacent(nodeM, BigDecimal.valueOf(138)))

    nodeH.adjacents = arrayListOf(Adjacent(nodeA, BigDecimal.valueOf(118)),
            Adjacent(nodeI, BigDecimal.valueOf(111)))

    nodeI.adjacents = arrayListOf(Adjacent(nodeH, BigDecimal.valueOf(111)),
            Adjacent(nodeJ, BigDecimal.valueOf(70)))

    nodeJ.adjacents = arrayListOf(Adjacent(nodeI, BigDecimal.valueOf(70)),
            Adjacent(nodeK, BigDecimal.valueOf(75)))

    nodeK.adjacents = arrayListOf(Adjacent(nodeJ, BigDecimal.valueOf(75)),
            Adjacent(nodeL, BigDecimal.valueOf(120)))

    nodeL.adjacents = arrayListOf(Adjacent(nodeF, BigDecimal.valueOf(138)),
            Adjacent(nodeK, BigDecimal.valueOf(120)),
            Adjacent(nodeG, BigDecimal.valueOf(138)))

    nodeM.adjacents = arrayListOf(Adjacent(nodeE, BigDecimal.valueOf(211)),
            Adjacent(nodeG, BigDecimal.valueOf(101)),
            Adjacent(nodeN, BigDecimal.valueOf(90)))

    nodeN.adjacents = arrayListOf(Adjacent(nodeM, BigDecimal.valueOf(90)))

    val edge = CostEdge(nodeA, nodeM)
//    UniformCostSearch.resolve(edge)
//    val algorithm = AlgorithmFactory.getAlgorithm(Methods.UCS)
//    algorithm.resolve(edge)
//    AlgorithmFactory.getAlgorithm(Methods.DFS).resolve(prepareTreeNodes())

//    log.info("Path --> ${UniformCostSearch.retrievePath(nodeM).map { it.value }}")

}

/**
 *
 *      N4 --> N2 --> N5
 *      |     / | \     \_
 *      |    /  |  \     _ N7
 *      |   /   |   \   /
 *      N1 --> N3 --> N6
 */

fun prepareTreeNodes(): TreeNode {

    val node1 = TreeNode(BigDecimal.valueOf(1))
    val node2 = TreeNode(BigDecimal.valueOf(2))
    val node3 = TreeNode(BigDecimal.valueOf(3))
    val node4 = TreeNode(BigDecimal.valueOf(4))
    val node5 = TreeNode(BigDecimal.valueOf(5))
    val node6 = TreeNode(BigDecimal.valueOf(6))
    val node7 = TreeNode(BigDecimal.valueOf(7))

    node4.adjacents = arrayListOf(node1, node2)
    node2.adjacents = arrayListOf(node1, node3, node5, node6)
    node3.adjacents = arrayListOf(node6)
    node5.adjacents = arrayListOf(node7)
    node6.adjacents = arrayListOf(node7)

    return node4

}
