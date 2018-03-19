package cse.study.search.algorithm.uniformed

import cse.study.search.algorithm.domain.Algorithm
import cse.study.search.entity.uninformed.TreeNode
import org.slf4j.LoggerFactory
import java.util.*

class DepthFirstSearch : Algorithm<TreeNode> {

    private val log = LoggerFactory.getLogger(javaClass.simpleName)

    private val stack: Stack<TreeNode> = Stack()
    private val graph: MutableSet<Any> = mutableSetOf()

    override fun resolve(node: TreeNode) {

        clear()
        insert(node)

        while (!stack.isEmpty()) {

            stack.pop()
                    .also { graph.add(it.data) }
                    .also { log.info("${it.data}. node popped") }
                    ?.adjacents
                    ?.also { log.info("Adjacents: $it") }
                    ?.forEach { it.takeIf { it.visited } ?: insert(it) }

        }

        log.info("The DFS graph is $graph")

    }

    private fun insert(node: TreeNode) {
        node.apply { visited() }
                .also { log.info("${it.data}. node pushed") }
                .let { stack.push(it) }
                .also { log.info("Stack --> $stack") }
    }

    private fun clear() {
        stack.clear()
        graph.clear()
    }

}