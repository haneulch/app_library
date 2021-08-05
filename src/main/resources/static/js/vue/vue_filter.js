
Vue.filter('currency', function (num) {
	if ( isNaN(num)) num = 0;
	return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
});
