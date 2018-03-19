package cse.study.search.algorithm.uniformed

import cse.study.search.algorithm.AlgorithmFactory
import cse.study.search.algorithm.Methods
import cse.study.search.entity.uninformed.CostAdjacent
import cse.study.search.entity.uninformed.CostEdge
import cse.study.search.entity.uninformed.CostNode
import spock.lang.Specification

class UniformCostSearchSpec extends Specification {

    def "resolve problem with ucs should succeed"() {
        given:
        def nodeA = new CostNode("A")
        def nodeB = new CostNode("B")
        def nodeC = new CostNode("C")
        def nodeD = new CostNode("D")
        def nodeE = new CostNode("E")
        def nodeF = new CostNode("F")
        def nodeG = new CostNode("G")
        def nodeH = new CostNode("H")
        def nodeI = new CostNode("I")
        def nodeJ = new CostNode("J")
        def nodeK = new CostNode("K")
        def nodeL = new CostNode("L")
        def nodeM = new CostNode("M")
        def nodeN = new CostNode("N")

        nodeA.adjacents = [new CostAdjacent(nodeB, BigDecimal.valueOf(75)),
                           new CostAdjacent(nodeD, BigDecimal.valueOf(140)),
                           new CostAdjacent(nodeH, BigDecimal.valueOf(118))]

        nodeB.adjacents = [new CostAdjacent(nodeA, BigDecimal.valueOf(75)),
                           new CostAdjacent(nodeC, BigDecimal.valueOf(71))]

        nodeC.adjacents = [new CostAdjacent(nodeB, BigDecimal.valueOf(71)),
                           new CostAdjacent(nodeD, BigDecimal.valueOf(151))]

        nodeD.adjacents = [new CostAdjacent(nodeA, BigDecimal.valueOf(140)),
                           new CostAdjacent(nodeC, BigDecimal.valueOf(151)),
                           new CostAdjacent(nodeE, BigDecimal.valueOf(99)),
                           new CostAdjacent(nodeF, BigDecimal.valueOf(80))]

        nodeE.adjacents = [new CostAdjacent(nodeD, BigDecimal.valueOf(99)),
                           new CostAdjacent(nodeM, BigDecimal.valueOf(211))]

        nodeF.adjacents = [new CostAdjacent(nodeD, BigDecimal.valueOf(80)),
                           new CostAdjacent(nodeG, BigDecimal.valueOf(97)),
                           new CostAdjacent(nodeL, BigDecimal.valueOf(138))]

        nodeG.adjacents = [new CostAdjacent(nodeF, BigDecimal.valueOf(97)),
                           new CostAdjacent(nodeL, BigDecimal.valueOf(138)),
                           new CostAdjacent(nodeM, BigDecimal.valueOf(101))]

        nodeH.adjacents = [new CostAdjacent(nodeA, BigDecimal.valueOf(118)),
                           new CostAdjacent(nodeI, BigDecimal.valueOf(111))]

        nodeI.adjacents = [new CostAdjacent(nodeH, BigDecimal.valueOf(111)),
                           new CostAdjacent(nodeJ, BigDecimal.valueOf(70))]

        nodeJ.adjacents = [new CostAdjacent(nodeI, BigDecimal.valueOf(70)),
                           new CostAdjacent(nodeK, BigDecimal.valueOf(75))]

        nodeK.adjacents = [new CostAdjacent(nodeJ, BigDecimal.valueOf(75)),
                           new CostAdjacent(nodeL, BigDecimal.valueOf(120))]

        nodeL.adjacents = [new CostAdjacent(nodeF, BigDecimal.valueOf(138)),
                           new CostAdjacent(nodeK, BigDecimal.valueOf(120)),
                           new CostAdjacent(nodeG, BigDecimal.valueOf(138))]

        nodeM.adjacents = [new CostAdjacent(nodeE, BigDecimal.valueOf(211)),
                           new CostAdjacent(nodeG, BigDecimal.valueOf(101)),
                           new CostAdjacent(nodeN, BigDecimal.valueOf(90))]

        nodeN.adjacents = [new CostAdjacent(nodeM, BigDecimal.valueOf(90))]

        def edge = new CostEdge(nodeA, nodeM)


        def algorithm = AlgorithmFactory.getAlgorithm(Methods.UCS)

        when:
        algorithm.resolve(edge)

        then:
        println(algorithm.retrievePath(nodeM)
                .stream()
                .map { it.value }
                .toArray())
    }

}
