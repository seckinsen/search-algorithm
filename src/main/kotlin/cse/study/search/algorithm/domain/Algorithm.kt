package cse.study.search.algorithm.domain

interface Algorithm<in T> {

    fun resolve(node: T)

}