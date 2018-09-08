/**
 * Created by administered on 2018-09-08.
 */
$(function() {

    var registerUrl = '/o2o/category/add';
    $('#submit').click(function() {
        var category = {};
        category.categoryName=$("#categoryname").val();
        category.parentId=$("#parentid").val();
        category.sort=$("#sort").val();
        category.description=$("#description").val();

        var formData = new FormData();

        formData.append('categoryData', JSON.stringify(category));
        $.ajax({
            url : registerUrl,
            type : 'POST',
            data : formData,
            contentType : false,
            processData : false,
            cache : false,
            success : function(data) {
                if (data.success) {
                    $.toast('提交成功！');
                    window.location.href = '/o2o/shop/category/add';
                } else {
                    $.toast('提交失败！');
                }
            }
        });
    });

    $('#back').click(function() {
        window.location.href = '/o2o/shop/categoryAdd';
    });
});
