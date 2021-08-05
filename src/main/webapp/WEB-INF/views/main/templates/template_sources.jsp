<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<script type="text/x-template" id="pagination-template">
	<div id="pagination">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item" v-for="i in pagearr" v-bind:key="i" v-bind:class="{active : i == number + 1}"><a class="page-link" @click="pageChange(i)">{{i}}</a></li>				
			</ul>
		</nav>
	</div>
</script>
