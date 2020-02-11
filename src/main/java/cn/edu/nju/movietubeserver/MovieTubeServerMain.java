package cn.edu.nju.movietubeserver;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author dc
 * @date 2019/12/20 17:56
 */
@EnableEncryptableProperties
@EnableTransactionManagement(proxyTargetClass = true)
@EnableCaching
@SpringBootApplication
public class MovieTubeServerMain
{

    public static void main(String[] args)
    {
        SpringApplication.run(MovieTubeServerMain.class, args);
    }
}
