import Common from './common_vue.js';
import pageComp from './page_component.js';
import './vue_filter.js';

var model = {
	search: '',
	isActive: true,
	name: '',
	address: '',
	link: '/place/findByNameWithPage',
	content: [],
	totalPages: 0,
	totalElements: 0,
	number: 0
};

new Vue({
	el: '#example',
	data() {
		return model;
	},
	mounted() {
		var _vue = this;
		Common.fetch('/place/findByNameWithPage', { search: '', page : 0 }, function (data) {
			$.extend(_vue, data);
		});
	},
	watch: {
		/* 서버 데이터 검색 */
		search(v) {
			var param = { search: v };
			var _vue = this;
			Common.fetch('/place/findByNameWithPage', param, function (data) {
				$.extend(_vue, data);
			});
		}
	},
	methods: {
		parentMethod(content, number) {
			this.content = content;
			this.number = number;
		},
		addClick() {
			this.isActive = false;
		},
		updateItem(k) {
			var _vue = this;

			var params = {
				seq: _vue.content[k].seq,
				name: _vue.content[k].name,
				address: _vue.content[k].address
			};

			if (params.name && params.address) {
				Common.fetch('/place/create', params, function (data) {
					_vue.content.splice(k, 1, data);
				});
			}
		},
		deleteItem(k) {
			var _vue = this;

			Common.fetch('/place/delete', { seq: _vue.content[k].seq}, function (data) {
				if (data) {
					_vue.content.splice(k, 1);
				}
			});
		},
		saveItem() {
			var _vue = this;
			var params = { name: _vue.name, address: _vue.address };
			if (params.name && params.address) {
				Common.fetch('/place/create', params, function (data) {
					_vue.name = '';
					_vue.address = '';
					_vue.content.push(data);
				});
			}
		},
		cancelItem() {
			this.isActive = true;
		}
	},
	components: {
		'pagination': pageComp
	}
});