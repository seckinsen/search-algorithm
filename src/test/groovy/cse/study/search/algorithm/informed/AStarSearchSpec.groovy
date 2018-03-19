package cse.study.search.algorithm.informed

import cse.study.search.algorithm.AlgorithmFactory
import cse.study.search.algorithm.Methods
import cse.study.search.entity.informed.AStarAdjacent
import cse.study.search.entity.informed.AStarEdge
import cse.study.search.entity.informed.AStarNode
import cse.study.search.entity.informed.AStarPath
import spock.lang.Specification

class AStarSearchSpec extends Specification {

    def "resolve problem with a* should succeed"() {
        given:
        def nodeA = new AStarNode("A", new AStarPath(BigDecimal.valueOf(366)))
        def nodeB = new AStarNode("B", new AStarPath(BigDecimal.valueOf(374)))
        def nodeC = new AStarNode("C", new AStarPath(BigDecimal.valueOf(380)))
        def nodeD = new AStarNode("D", new AStarPath(BigDecimal.valueOf(253)))
        def nodeE = new AStarNode("E", new AStarPath(BigDecimal.valueOf(178)))
        def nodeF = new AStarNode("F", new AStarPath(BigDecimal.valueOf(193)))
        def nodeG = new AStarNode("G", new AStarPath(BigDecimal.valueOf(98)))
        def nodeH = new AStarNode("H", new AStarPath(BigDecimal.valueOf(329)))
        def nodeI = new AStarNode("I", new AStarPath(BigDecimal.valueOf(244)))
        def nodeJ = new AStarNode("J", new AStarPath(BigDecimal.valueOf(241)))
        def nodeK = new AStarNode("K", new AStarPath(BigDecimal.valueOf(242)))
        def nodeL = new AStarNode("L", new AStarPath(BigDecimal.valueOf(160)))
        def nodeM = new AStarNode("M", new AStarPath(BigDecimal.valueOf(0)))
        def nodeN = new AStarNode("N", new AStarPath(BigDecimal.valueOf(77)))

        nodeA.adjacents = [new AStarAdjacent(nodeB, BigDecimal.valueOf(75)),
                           new AStarAdjacent(nodeD, BigDecimal.valueOf(140)),
                           new AStarAdjacent(nodeH, BigDecimal.valueOf(118))]

        nodeB.adjacents = [new AStarAdjacent(nodeA, BigDecimal.valueOf(75)),
                           new AStarAdjacent(nodeC, BigDecimal.valueOf(71))]

        nodeC.adjacents = [new AStarAdjacent(nodeB, BigDecimal.valueOf(71)),
                           new AStarAdjacent(nodeD, BigDecimal.valueOf(151))]

        nodeD.adjacents = [new AStarAdjacent(nodeA, BigDecimal.valueOf(140)),
                           new AStarAdjacent(nodeC, BigDecimal.valueOf(151)),
                           new AStarAdjacent(nodeE, BigDecimal.valueOf(99)),
                           new AStarAdjacent(nodeF, BigDecimal.valueOf(80))]

        nodeE.adjacents = [new AStarAdjacent(nodeD, BigDecimal.valueOf(99)),
                           new AStarAdjacent(nodeM, BigDecimal.valueOf(211))]

        nodeF.adjacents = [new AStarAdjacent(nodeD, BigDecimal.valueOf(80)),
                           new AStarAdjacent(nodeG, BigDecimal.valueOf(97)),
                           new AStarAdjacent(nodeL, BigDecimal.valueOf(138))]

        nodeG.adjacents = [new AStarAdjacent(nodeF, BigDecimal.valueOf(97)),
                           new AStarAdjacent(nodeL, BigDecimal.valueOf(138)),
                           new AStarAdjacent(nodeM, BigDecimal.valueOf(101))]

        nodeH.adjacents = [new AStarAdjacent(nodeA, BigDecimal.valueOf(118)),
                           new AStarAdjacent(nodeI, BigDecimal.valueOf(111))]

        nodeI.adjacents = [new AStarAdjacent(nodeH, BigDecimal.valueOf(111)),
                           new AStarAdjacent(nodeJ, BigDecimal.valueOf(70))]

        nodeJ.adjacents = [new AStarAdjacent(nodeI, BigDecimal.valueOf(70)),
                           new AStarAdjacent(nodeK, BigDecimal.valueOf(75))]

        nodeK.adjacents = [new AStarAdjacent(nodeJ, BigDecimal.valueOf(75)),
                           new AStarAdjacent(nodeL, BigDecimal.valueOf(120))]

        nodeL.adjacents = [new AStarAdjacent(nodeF, BigDecimal.valueOf(138)),
                           new AStarAdjacent(nodeK, BigDecimal.valueOf(120)),
                           new AStarAdjacent(nodeG, BigDecimal.valueOf(138))]

        nodeM.adjacents = [new AStarAdjacent(nodeE, BigDecimal.valueOf(211)),
                           new AStarAdjacent(nodeG, BigDecimal.valueOf(101)),
                           new AStarAdjacent(nodeN, BigDecimal.valueOf(90))]

        nodeN.adjacents = [new AStarAdjacent(nodeM, BigDecimal.valueOf(90))]

        def edge = new AStarEdge(nodeA, nodeM)


        def algorithm = AlgorithmFactory.getAlgorithm(Methods.ASS)

        when:
        algorithm.resolve(edge)

        then:
        println(algorithm.retrievePath(nodeM)
                .stream()
                .map { it.value }
                .toArray())
    }

}
