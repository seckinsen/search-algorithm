package cse.study.search.entity.informed

class AStarNode @JvmOverloads constructor(val value: Any,
                                          var path: AStarPath,
                                          var adjacents: List<AStarAdjacent> = emptyList(),
                                          var parent: AStarNode? = null) {

    override fun toString(): String {
        return "AStarNode(value=$value, path=f(${path.f}) = h(${path.h}) + g(${path.g}))"
    }

}