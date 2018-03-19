package cse.study.search.algorithm.informed

import cse.study.search.algorithm.AlgorithmFactory
import cse.study.search.algorithm.Methods
import cse.study.search.entity.GreedyEdge
import cse.study.search.entity.GreedyNode
import spock.lang.Specification

class GreedySearchSpec extends Specification {

    /**
     *
     *              -- 9 -- E
     *            |
     *    -- 3 -- B
     *  |         |
     *  |           -- 8 -- F
     *  |
     *  |           -- 12 -- G
     *  |         |
     * (A) -- 6 -- C
     *  |         |
     *  |           -- 14 -- H          -- 1 -- L
     *  |                              |
     *  |                     -- 5 -- (J) -- 10 -- M
     *  |                   |          |
     *    -- 5 -- D -- 7 -- I           -- 2  -- N
     *                      |
     *                        -- 6 -- K
     */

    def "resolve problem with gs should succeed"() {
        given:
        def nodeA = new GreedyNode("A")
        def nodeB = new GreedyNode("B", BigDecimal.valueOf(3))
        def nodeC = new GreedyNode("C", BigDecimal.valueOf(6))
        def nodeD = new GreedyNode("D", BigDecimal.valueOf(5))
        def nodeE = new GreedyNode("E", BigDecimal.valueOf(9))
        def nodeF = new GreedyNode("F", BigDecimal.valueOf(8))
        def nodeG = new GreedyNode("G", BigDecimal.valueOf(12))
        def nodeH = new GreedyNode("H", BigDecimal.valueOf(14))
        def nodeI = new GreedyNode("I", BigDecimal.valueOf(7))
        def nodeJ = new GreedyNode("J", BigDecimal.valueOf(5))
        def nodeK = new GreedyNode("K", BigDecimal.valueOf(6))
        def nodeL = new GreedyNode("L", BigDecimal.valueOf(1))
        def nodeM = new GreedyNode("M", BigDecimal.valueOf(10))
        def nodeN = new GreedyNode("N", BigDecimal.valueOf(2))

        nodeA.adjacents = [nodeB, nodeC, nodeD]
        nodeB.adjacents = [nodeE, nodeF]
        nodeC.adjacents = [nodeG, nodeH]
        nodeD.adjacents = [nodeI]
        nodeI.adjacents = [nodeJ, nodeK]
        nodeJ.adjacents = [nodeL, nodeM, nodeN]

        def edge = new GreedyEdge(nodeA, nodeJ)

        def algorithm = AlgorithmFactory.getAlgorithm(Methods.GS)

        when:
        algorithm.resolve(edge)

        then:
        println(algorithm.retrievePath(nodeJ)
                .stream()
                .map { it.value }
                .toArray())
    }

}
