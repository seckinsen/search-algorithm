package cse.study.search.algorithm.uniformed

import cse.study.search.algorithm.domain.Algorithm
import cse.study.search.entity.uninformed.TreeNode
import org.slf4j.LoggerFactory
import java.util.*

class BreadthFirstSearch : Algorithm<TreeNode> {

    private val log = LoggerFactory.getLogger(javaClass.simpleName)

    private val queue: Queue<TreeNode> = ArrayDeque<TreeNode>()
    private val graph: MutableSet<Any> = mutableSetOf()

    override fun resolve(node: TreeNode) {

        clear()
        enqueue(node)

        while (!queue.isEmpty()) {

            queue.poll()
                    .also { graph.add(it.data) }
                    ?.also { log.info("${it.data}. node dequeue") }
                    ?.adjacents
                    ?.also { log.info("Adjacents: $it") }
                    ?.forEach { it.takeIf { it.visited } ?: enqueue(it) }

        }

        log.info("The BFS graph is $graph")

    }

    private fun enqueue(node: TreeNode) {
        node.apply { visited() }
                .also { log.info("${it.data}. node enqueue") }
                .let { queue.add(it) }
                .also { log.info("Queue --> $queue") }
    }

    private fun clear() {
        queue.clear()
        graph.clear()
    }

}
