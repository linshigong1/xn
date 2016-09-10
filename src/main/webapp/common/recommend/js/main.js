window.onload = function(){
	//选择品类单选功能
	var select_category_input = document.getElementById("select_category_input");
	var select_category_ul = document.getElementById("select_category_ul");
	var select_category_ul_li = select_category_ul.getElementsByTagName("li");

	for(var i = 0; i < select_category_ul_li.length; i++){
		select_category_ul_li[i].addEventListener("click", function(event){
			//改input 赋值
			var value = this.dataset.value;
			select_category_input.value = value;

			//变换样式
			//清楚未选择的样式
			for(var j = 0; j < select_category_ul_li.length; j++ ){
				select_category_ul_li[j].className = "";
			}

			this.className = "selected";
		});
	}


	//选择单位单选功能
	var select_company_input = document.getElementById("select_company_input");
	var select_company_ul = document.getElementById("select_company_ul");
	var select_company_ul_li = select_company_ul.getElementsByTagName("li");

	for(var i = 0; i < select_company_ul_li.length; i++){
		select_company_ul_li[i].addEventListener("click", function(event){
			//改input 赋值
			var value = this.dataset.value;
			select_company_input.value = value;

			//变换样式
			//清楚未选择的样式
			for(var j = 0; j < select_company_ul_li.length; j++ ){
				select_company_ul_li[j].className = "";
			}

			this.className = "selected";
		});
	}
		
}//window.onload

//下面用于图片上传预览功能
function setImagePreview() {
    //input
    var docObj = document.getElementById("doc");
	//img
    var imgObjPreview = document.getElementById("preview");
    //div
    var divs = document.getElementById("localImag");
    if (docObj.files && docObj.files[0]) {
        imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
    } else {
        //IE下，使用滤镜
        docObj.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("localImag");
                    
        try {
            localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
        } catch(e) {
            alert("您上传的图片格式不正确，请重新选择!");
             return false;
        }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
    }

    //隐藏span内容
    var spans  = document.getElementById("pic_box").getElementsByTagName("span");
    for(var i = 0; i < spans.length; i++){
    	spans[i].style.display = "none";
    }
    document.getElementById("pic_box").style.backgroundImage = "url(img/empty.png)";
    return true;
}


