var Theme = {
	activate: function(name) {
		$.ajax({
			type:'POST',
			url: 'user/userProfile/changeTheme',
			data:'theme=' + name,
			dataType: 'json',
			success: function(data){
				if(data.status == '0'){
					$('#current-theme').attr('href', 'stylesheets/themes/' + name + '/style.css');
				}else{
					alert('更换主题失败');
				}
			}
		});
    },
}