package cse.study.search.algorithm.uniformed

import cse.study.search.algorithm.AlgorithmFactory
import cse.study.search.algorithm.Methods
import cse.study.search.entity.uninformed.Adjacent
import cse.study.search.entity.uninformed.CostNode
import cse.study.search.entity.uninformed.CostEdge
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

        nodeA.adjacents = [new Adjacent(nodeB, BigDecimal.valueOf(75)),
                           new Adjacent(nodeD, BigDecimal.valueOf(140)),
                           new Adjacent(nodeH, BigDecimal.valueOf(118))]

        nodeB.adjacents = [new Adjacent(nodeA, BigDecimal.valueOf(75)),
                           new Adjacent(nodeC, BigDecimal.valueOf(71))]

        nodeC.adjacents = [new Adjacent(nodeB, BigDecimal.valueOf(71)),
                           new Adjacent(nodeD, BigDecimal.valueOf(151))]

        nodeD.adjacents = [new Adjacent(nodeA, BigDecimal.valueOf(140)),
                           new Adjacent(nodeC, BigDecimal.valueOf(151)),
                           new Adjacent(nodeE, BigDecimal.valueOf(99)),
                           new Adjacent(nodeF, BigDecimal.valueOf(80))]

        nodeE.adjacents = [new Adjacent(nodeD, BigDecimal.valueOf(99)),
                           new Adjacent(nodeM, BigDecimal.valueOf(211))]

        nodeF.adjacents = [new Adjacent(nodeD, BigDecimal.valueOf(80)),
                           new Adjacent(nodeG, BigDecimal.valueOf(97)),
                           new Adjacent(nodeL, BigDecimal.valueOf(138))]

        nodeG.adjacents = [new Adjacent(nodeF, BigDecimal.valueOf(97)),
                           new Adjacent(nodeL, BigDecimal.valueOf(101)),
                           new Adjacent(nodeM, BigDecimal.valueOf(138))]

        nodeH.adjacents = [new Adjacent(nodeA, BigDecimal.valueOf(118)),
                           new Adjacent(nodeI, BigDecimal.valueOf(111))]

        nodeI.adjacents = [new Adjacent(nodeH, BigDecimal.valueOf(111)),
                           new Adjacent(nodeJ, BigDecimal.valueOf(70))]

        nodeJ.adjacents = [new Adjacent(nodeI, BigDecimal.valueOf(70)),
                           new Adjacent(nodeK, BigDecimal.valueOf(75))]

        nodeK.adjacents = [new Adjacent(nodeJ, BigDecimal.valueOf(75)),
                           new Adjacent(nodeL, BigDecimal.valueOf(120))]

        nodeL.adjacents = [new Adjacent(nodeF, BigDecimal.valueOf(138)),
                           new Adjacent(nodeK, BigDecimal.valueOf(120)),
                           new Adjacent(nodeG, BigDecimal.valueOf(138))]

        nodeM.adjacents = [new Adjacent(nodeE, BigDecimal.valueOf(211)),
                           new Adjacent(nodeG, BigDecimal.valueOf(101)),
                           new Adjacent(nodeN, BigDecimal.valueOf(90))]

        nodeN.adjacents = [new Adjacent(nodeM, BigDecimal.valueOf(90))]

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
