/**
 * module : js 코드를 담고 있는 파일, 변수, 명령문, 함수, 클래스의 집합체
 * 다른 js 파일에서 현재 js 문서의 멤버가 필요하면 export한다.
 */
// 변수 내보내기
export let user = "홍길동	";

//  json 형식으로 내보내기
const name = "apple";
const price = "1000";
export let msg={name, price}
// js 메소드 내보내기
export function sayHi(user){
	return `Hello, ${user}`;
}
// js파일 기본값 내보내기
// js에서의 디폴트 값은 다른 js에서 import할때 이름을 정해주어야 한다
export default "하나의 값을 지정하고 그 값을 다른 모듈에서 사용";
// 배열 내보내기
export let datas = ["커피", "맥주", "콜라"]
// 함수 여러개 내보내기
function f1(ir) {
	return `안녕 ${ir}`;
}

function f2(ir) {
	return `반가워 ${ir}`;
}
export {f1,f2};