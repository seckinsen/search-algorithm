package cse.study.search.entity.uninformed

class TreeNode @JvmOverloads constructor(val data: Any,
                                         var visited: Boolean = false,
                                         var adjacents: List<TreeNode> = emptyList()) {

    fun visited() {
        this.visited = true
    }

    override fun toString(): String {
        return "TreeNode(data=$data, visited=$visited)"
    }

}
