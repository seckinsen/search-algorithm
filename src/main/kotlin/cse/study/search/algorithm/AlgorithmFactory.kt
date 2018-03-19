package cse.study.search.algorithm

import cse.study.search.algorithm.uniformed.BreadthFirstSearch
import cse.study.search.algorithm.uniformed.DepthFirstSearch
import cse.study.search.algorithm.informed.GreedySearch
import cse.study.search.algorithm.uniformed.UniformCostSearch

object AlgorithmFactory {

    @JvmStatic
    fun getAlgorithm(method: Methods) = when (method) {
        Methods.BFS -> BreadthFirstSearch()
        Methods.DFS -> DepthFirstSearch()
        Methods.UCS -> UniformCostSearch()
        Methods.GS -> GreedySearch()
    }

}