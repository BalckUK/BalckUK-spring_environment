package kh.spring.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.stereotype.Service;

/** ScheduleServiceImpl(class) **/
@Service("ScheduleJob") // xml파일 job의 targetObject에 설정하는 bean 값
@DisallowConcurrentExecution // 동시 실행 방지 어노테이션 => 구글링 참조
								// 클러스터링에서는 동작하지 않는다는 글을 보아서 연구가 더 필요
public class ScheduleServiceImpl implements ScheduleService {
	// 스케줄러로 작동할 메소드(xml파일 job의 targetMethod 부분에 설정)
	@Override
	public void saveTest() {
		System.out.println("스케줄러 테스트입니다");
	}
}
