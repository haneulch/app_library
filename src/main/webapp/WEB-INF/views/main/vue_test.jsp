<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<script src="../js/vue/vue.js"></script>
<script src="../js/jquery/jquery.min.js"></script>
<script src="../js/bootstrap/bootstrap.min.js"></script>
<script type="module" src="../js/vue/list_vue.js"></script>
</head>

<body>
	<div id="example" class="container" v-cloak>
		<h2>total : {{totalElements}}</h2>
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="search" v-model="search">
		</div>
		<table id="list" class="table">
			<colgroup>
				<col width="20%">
				<col width="20%">
				<col width="20%">
				<col width="20%">
				<col width="20%">
			</colgroup>
			<thead>
				<tr>	
					<th scope="col">SEQ</th>
					<th scope="col">NAME</th>
					<th scope="col">ADDRESS</th>
					<th scope="col">REG_DT</th>
					<th scope="col">-</th>
				</tr>
			</thead>
			<tbody id="items">
				<tr v-for="(i, k) in content" :key="k">
					<th scope="row">{{i.seq}}</th>
					<td>
						<input type="text" class="form-control" placeholder="name" v-model="i.name">
					</td>
					<td>
						<input type="text" class="form-control" placeholder="name" v-model="i.address">
					</td>
					<td><button type="button" class="btn btn-primary" @click="updateItem(k)">수정</button></td>
					<td><button type="button" class="btn btn-primary" @click="deleteItem(k)">삭제</button></td>
				</tr>
				<tr v-bind:class="{ none : isActive }">
					<td colspan="2">
						<div class="input-group mb-3">
							<input type="text" class="form-control" placeholder="name" v-model="name">
						</div>
					</td>
					<td>
						<div class="input-group mb-3">
							<input type="text" class="form-control" placeholder="address" v-model="address">
						</div>
					</td>
					<td>
						<button type="button" class="btn btn-primary" @click="saveItem">저장</button>
					</td>
					<td>
						<button type="button" class="btn btn-primary" @click="cancelItem">취소</button>
					</td>
				</tr>
			</tbody>
		</table>
		
		<button type="button" class="btn btn-primary" v-bind:class="{none : !isActive}" @click="addClick">추가</button>
		
		<pagination @childs-event="parentMethod" :total-pages="totalPages" :number="number" :link="link"></pagination>
	</div>
</body>
</html>

<jsp:include page="./templates/template_sources.jsp"/>