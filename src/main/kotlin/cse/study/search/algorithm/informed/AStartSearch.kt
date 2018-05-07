package cse.study.search.algorithm.informed

import cse.study.search.algorithm.domain.AStartNodeComparator
import cse.study.search.algorithm.domain.Algorithm
import cse.study.search.entity.informed.AStarEdge
import cse.study.search.entity.informed.AStarNode
import org.slf4j.LoggerFactory
import java.util.*

class AStartSearch : Algorithm<AStarEdge> {

    private val log = LoggerFactory.getLogger(javaClass.simpleName)

    private val priorityQueue: PriorityQueue<AStarNode> = PriorityQueue(AStartNodeComparator)
    private val visited: MutableSet<AStarNode> = mutableSetOf()
    private var found: Boolean = false

    override fun resolve(node: AStarEdge) {

        clear()
        enqueue(node.start)

        while (!priorityQueue.isEmpty() && !found) {

            val currentNode = priorityQueue.poll()
                    .also { visited.add(it) }
                    .let { it to it.value }
                    .also { it.second.check(node.goal.value) }
                    .first
                    .apply { path.f = path.h + path.g }

            currentNode.adjacents
                    .forEach { adjacent ->
                        val target = adjacent.target
                        val cost = adjacent.cost
                        val targetG = currentNode.path.g + cost
                        val targetF = targetG + target.path.h

                        if (!visited.contains(target) && !priorityQueue.contains(target)) {
                            target.path.g = targetG
                            target.path.f = targetF
                            target.parent = currentNode

                            enqueue(target)
                        } else if (priorityQueue.contains(target) && targetF < target.path.f) {
                            target.parent = currentNode
                            priorityQueue.remove(target)
                            enqueue(target)
                        }

                    }

        }

    }

    private fun Any.check(value: Any) = this.takeUnless { it == value } ?: found.not()

    private fun enqueue(node: AStarNode) {
        node.also { log.info("${it.value}. node enqueue") }
                .let { priorityQueue.add(it) }
                .also { log.info("Queue --> $priorityQueue") }
    }

    private fun clear() {
        priorityQueue.clear()
        visited.clear()
    }

    fun retrievePath(target: AStarNode): List<AStarNode> {

        val path = mutableListOf<AStarNode>()
        var node: AStarNode? = target

        while (node != null) {
            path.add(node)
            node = node.parent
        }

        path.reverse()

        return path

    }

}