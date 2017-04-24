package crawler;

public enum FinalMatchStatusEnum {
	ZERO("状态零"), // 无精确结果，放弃；对该资源匹配状态标记为状态0
	ONE("状态一"), // 精准匹配MV名，未匹配歌手名，标记为状态1
	TWO("状态二"), // 精确匹配MV名和艺人名，标记为状态2
	THREE("状态三"), // 虾米音乐歌名包含音悦台歌名，标记为状态3
	FOUR("状态四"); // 音悦台歌名包含虾米音乐歌名，标记为状态4

	public String name;

	private FinalMatchStatusEnum(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
