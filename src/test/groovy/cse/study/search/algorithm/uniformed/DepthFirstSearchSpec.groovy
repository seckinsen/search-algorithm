package cse.study.search.algorithm.uniformed

import cse.study.search.algorithm.AlgorithmFactory
import cse.study.search.algorithm.Methods
import cse.study.search.entity.uninformed.TreeNode
import spock.lang.Specification

class DepthFirstSearchSpec extends Specification {

    /**
     *
     *      N4 --> N2 --> N5
     *      |     / | \     \_
     *      |    /  |  \     _ N7
     *      |   /   |   \   /
     *      N1 --> N3 --> N6
     */

    def "resolve problem with dfs should succeed"() {
        given:
        def node1 = new TreeNode("1")
        def node2 = new TreeNode("2")
        def node3 = new TreeNode("3")
        def node4 = new TreeNode("4")
        def node5 = new TreeNode("5")
        def node6 = new TreeNode("6")
        def node7 = new TreeNode("7")

        node4.adjacents = [node1, node2]
        node1.adjacents = [node2, node3, node4]
        node2.adjacents = [node1, node3, node5, node6, node4]
        node3.adjacents = [node6,node1, node2]
        node5.adjacents = [node7, node2]
        node6.adjacents = [node7, node5]
        node7.adjacents = [node5, node6]

        expect:
        AlgorithmFactory.getAlgorithm(Methods.DFS).resolve(node4)
    }

}
