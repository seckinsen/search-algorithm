package cse.study.search.entity.uninformed

class CostNode @JvmOverloads constructor(val value: Any,
                                         var path: Path = Path(),
                                         var adjacents: List<Adjacent> = emptyList(),
                                         var parent: CostNode? = null) {

    override fun toString(): String {
        return "CostNode(value=$value, path=${path.cost})"
    }

}