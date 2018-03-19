package cse.study.search.algorithm

import cse.study.search.algorithm.domain.Algorithm

object NullSearch : Algorithm<Any> {

    override fun resolve(node: Any) {
        throw IllegalStateException("Null Search Algorithm")
    }

}