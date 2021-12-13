package org.prgrms.yas.domain.mission.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MissionStatusUpdateRequest {
	
	private Long missionStatusId;
	private int orders;
	private Long userDurationTime;
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	private LocalDateTime endTime;
	
	@Builder
	public MissionStatusUpdateRequest(
			Long missionStatusId, int orders, Long userDurationTime, LocalDateTime endTime
	) {
		this.missionStatusId = missionStatusId;
		this.orders = orders;
		this.userDurationTime = userDurationTime;
		this.endTime = endTime;
	}
}
