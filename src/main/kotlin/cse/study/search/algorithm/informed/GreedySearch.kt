package cse.study.search.algorithm.informed

import cse.study.search.algorithm.domain.Algorithm
import cse.study.search.algorithm.domain.GreedyNodeComparator
import cse.study.search.entity.informed.GreedyEdge
import cse.study.search.entity.informed.GreedyNode
import org.slf4j.LoggerFactory
import java.util.*

class GreedySearch : Algorithm<GreedyEdge> {

    private val log = LoggerFactory.getLogger(javaClass.simpleName)

    private val priorityQueue: PriorityQueue<GreedyNode> = PriorityQueue(GreedyNodeComparator)
    private var found: Boolean = false

    override fun resolve(node: GreedyEdge) {

        clear()
        enqueue(node.start)

        do {
            val currentNode = priorityQueue.poll()
                    .let { Pair(it, it.value) }
                    .also { it.second.check(node.goal.value) }
                    .first
                    .also { log.info("${it.value}. node dequeue") }

            log.info("**************************************************")

            currentNode.adjacents
                    .also { log.info("Adjacents: $it") }
                    .forEach { adjacent ->

                        log.info("Adjacent node (${adjacent.value}) with cost --> ${adjacent.cost}")

                        if (!adjacent.visited && !priorityQueue.contains(adjacent)) {
                            adjacent.apply { parent = currentNode }
                            log.info("Adjacent node (${adjacent.value}) with parent after assignment --> ${adjacent.parent?.value}")

                            enqueue(adjacent)
                        }

                        log.info("==================================================")
                    }

        } while (!priorityQueue.isEmpty() && !found)

    }

    private fun Any.check(value: Any) = this.takeUnless { it == value } ?: found.not()

    private fun enqueue(node: GreedyNode) {
        node.apply { visited() }
                .also { log.info("${it.value}. node enqueue") }
                .let { priorityQueue.add(it) }
                .also { log.info("Queue --> $priorityQueue") }
    }

    private fun clear() {
        priorityQueue.clear()
    }

    fun retrievePath(target: GreedyNode): List<GreedyNode> {

        val path = mutableListOf<GreedyNode>()
        var node: GreedyNode? = target

        while (node != null) {
            path.add(node)
            node = node.parent
        }

        path.reverse()

        return path

    }

}
