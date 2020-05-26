import com.xiattong.batis.domain.Blog;
import com.xiattong.batis.executor.XiaExecutor;
import com.xiattong.batis.mapper.BlogMapper;
import com.xiattong.batis.session.XiaConfiguration;
import com.xiattong.batis.session.XiaSqlSession;

public class XiabatisTest {
    public static void main(String[] args) {
        XiaSqlSession xiaSqlSession = new XiaSqlSession(new XiaConfiguration(),new XiaExecutor());
        BlogMapper blogMapper = xiaSqlSession.getMapper(BlogMapper.class);
        Blog blog1 = blogMapper.selectBlogById(1);
        Blog blog2 = blogMapper.selectBlogById2(1,1001);
        System.out.println(blog1);
        System.out.println(blog2);
    }
}
