let index = {
    init: function(){
        $("#btn-save").on("click", ()=>{
            this.save();
        });
    },
    save: function(){
        //alert('user의 save 함수 호출됨');
        let data = {
            username: ${"#username"}.val(),
            password: ${"#password"}.val(),
            email: ${"#email"}.val()
        }
        //console.log(data);

        $.ajax({
            type:"POST",
            url:"blog/api/user",
            data:JSOn.stringify(data),//http body 데이터
            contentType:"application/json; charset=UTF-8",//body데이터가 어떤 타입인지
            dataType:"json"//요청을 서버로 해서 응답이 왔을때 String(기본) -> Javacript 오브젝트로 변경
        }).done(function(resp){
            alert(회원가입이 완료되었습니다.);
            location.href = "/blog";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });//ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
    }
}

index.init();