package cse.study.search.algorithm.uniformed

import cse.study.search.algorithm.domain.Algorithm
import cse.study.search.algorithm.domain.CostNodeComparator
import cse.study.search.entity.uninformed.CostEdge
import cse.study.search.entity.uninformed.CostNode
import org.slf4j.LoggerFactory
import java.util.*

class UniformCostSearch : Algorithm<CostEdge> {

    private val log = LoggerFactory.getLogger(javaClass.simpleName)

    private val priorityQueue: PriorityQueue<CostNode> = PriorityQueue(CostNodeComparator)
    private val visited: MutableSet<CostNode> = mutableSetOf()
    private var found: Boolean = false

    override fun resolve(node: CostEdge) {

        clear()
        enqueue(node.start)

        do {
            val currentNode = priorityQueue.poll()
                    .also { visited.add(it) }
                    .also { visited.lastOrNull()?.also { log.info("${it.value}. node visited") } }
                    .let { Pair(it, it.value) }
                    .also { it.second.check(node.goal.value) }
                    .first
                    .also { log.info("${it.value}. node dequeue") }

            log.info("**************************************************")

            currentNode.adjacents
                    .also { log.info("Adjacents: $it") }
                    .forEach { adjacent ->
                        val target = adjacent.target
                        val cost = adjacent.cost

                        log.info("Target node (${target.value}) with cost --> $cost")

                        if (!visited.contains(target) && !priorityQueue.contains(target)) {
                            target.path.cost = cost + currentNode.path.cost
                            log.info("Target node (${target.value}) with path cost after calculation --> ${target.path.cost}")

                            target.parent = currentNode
                            log.info("Target node (${target.value}) with parent after assignment --> ${target.parent?.value}")

                            enqueue(target)
                        } else if (priorityQueue.contains(target) && target.path.cost > cost + currentNode.path.cost) {
                            target.parent = currentNode
                            log.info("Target node (${target.value}) with parent after reassignment --> ${target.parent?.value}")

                            priorityQueue.remove(target)
                            enqueue(target)
                        }

                        log.info("==================================================")
                    }

        } while (!priorityQueue.isEmpty() && !found)

    }

    private fun Any.check(value: Any) = this.takeUnless { it == value } ?: found.not()

    private fun enqueue(node: CostNode) {
        node.also { log.info("${it.value}. node enqueue") }
                .let { priorityQueue.add(it) }
                .also { log.info("Queue --> $priorityQueue") }
    }

    private fun clear() {
        priorityQueue.clear()
        visited.clear()
    }

    fun retrievePath(target: CostNode): List<CostNode> {

        val path = mutableListOf<CostNode>()
        var node: CostNode? = target

        while (node != null) {
            path.add(node)
            node = node.parent
        }

        path.reverse()

        return path

    }

}