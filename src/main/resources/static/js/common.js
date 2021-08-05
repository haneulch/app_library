/**
 * 공통 js
 */

var common = {
	fetch: function(url, param, _callBack) {

		var options = {
			method: 'POST',
			mode: 'cors',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json;charset=UTF-8'
			},
			body: JSON.stringify(param)
		};


		fetch(url, options)
			.then(function(response) {
				if (response && response.ok) {
					response.text().then(function(data) {
						var obj = data ? JSON.parse(data) : { data: true };

						if ($.isFunction(_callBack)) {
							_callBack(obj);
						}
					})
				}
			});
	}
};