package du.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface MemberMapper {
	@Select("select count(*) from members where email = #{email} and password = #{password}")
	public int isMember(MemberDto memberDto);

	@Select("select * from members where email = #{email} and password = #{password}")
	public MemberDto findMember(MemberDto memberDto);
	
	@Insert("insert into members(name,email,password) values(#{name},#{email},#{password})")
	void insertOne(MemberDto memberDto);
	
	@Select("SELECT * FROM members WHERE email = #{email}")
    MemberDto selectMemberById(@Param("email") String email);
}
