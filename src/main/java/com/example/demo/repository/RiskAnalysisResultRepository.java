package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.RiskAnalysisResult;
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< com.example:demo >--------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.3.2:clean (default-clean) @ demo ---
[INFO] Deleting /home/coder/Workspace/demo/target
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:resources (default-resources) @ demo ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.13.0:compile (default-compile) @ demo ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 32 source files with javac [debug parameters release 17] to target/classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskAnalysisController.java:[5,30] cannot find symbol
  symbol:   class RiskAnalysis
  location: package com.example.demo.model
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskAnalysisController.java:[19,17] cannot find symbol
  symbol:   class RiskAnalysis
  location: class com.example.demo.controller.RiskAnalysisController
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskAnalysisController.java:[24,53] cannot find symbol
  symbol:   class RiskAnalysis
  location: class com.example.demo.controller.RiskAnalysisController
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskAnalysisController.java:[24,12] cannot find symbol
  symbol:   class RiskAnalysis
  location: class com.example.demo.controller.RiskAnalysisController
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/RiskAnalysisResultRepository.java:[7,5] cannot find symbol
  symbol:   class List
  location: interface com.example.demo.repository.RiskAnalysisResultRepository
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskAnalysisController.java:[20,35] cannot find symbol
  symbol:   method getAllAnalyses()
  location: variable riskAnalysisService of type com.example.demo.service.RiskAnalysisService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskThresholdController.java:[30,36] cannot find symbol
  symbol:   method updateThreshold(java.lang.Long,com.example.demo.model.RiskThreshold)
  location: variable riskThresholdService of type com.example.demo.service.RiskThresholdService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/UserPortfolioController.java:[20,32] cannot find symbol
  symbol:   method updatePortfolio(java.lang.Long,com.example.demo.model.UserPortfolio)
  location: variable portfolioService of type com.example.demo.service.UserPortfolioService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/UserPortfolioController.java:[25,25] cannot find symbol
  symbol:   method deactivatePortfolio(java.lang.Long)
  location: variable portfolioService of type com.example.demo.service.UserPortfolioService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/RiskAnalysisServiceImpl.java:[19,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/RiskThresholdServiceImpl.java:[24,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/RiskThresholdServiceImpl.java:[32,26] cannot find symbol
  symbol:   method findByActiveTrue()
  location: variable repository of type com.example.demo.repository.RiskThresholdRepository
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/UserPortfolioServiceImpl.java:[24,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/UserPortfolioServiceImpl.java:[38,26] cannot find symbol
  symbol:   method findByUserId(java.lang.Long)
  location: variable repository of type com.example.demo.repository.UserPortfolioRepository
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/UserPortfolioServiceImpl.java:[41,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/UserServiceImpl.java:[24,26] cannot find symbol
  symbol:   method findByEmail(java.lang.String)
  location: variable repository of type com.example.demo.repository.UserRepository
[INFO] 16 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  10.995 s
[INFO] Finished at: 2025-12-18T17:54:57Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.13.0:compile (default-compile) on project demo: Compilation failure: Compilation failure: 
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskAnalysisController.java:[5,30] cannot find symbol
[ERROR]   symbol:   class RiskAnalysis
[ERROR]   location: package com.example.demo.model
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskAnalysisController.java:[19,17] cannot find symbol
[ERROR]   symbol:   class RiskAnalysis
[ERROR]   location: class com.example.demo.controller.RiskAnalysisController
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskAnalysisController.java:[24,53] cannot find symbol
[ERROR]   symbol:   class RiskAnalysis
[ERROR]   location: class com.example.demo.controller.RiskAnalysisController
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskAnalysisController.java:[24,12] cannot find symbol
[ERROR]   symbol:   class RiskAnalysis
[ERROR]   location: class com.example.demo.controller.RiskAnalysisController
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/RiskAnalysisResultRepository.java:[7,5] cannot find symbol
[ERROR]   symbol:   class List
[ERROR]   location: interface com.example.demo.repository.RiskAnalysisResultRepository
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskAnalysisController.java:[20,35] cannot find symbol
[ERROR]   symbol:   method getAllAnalyses()
[ERROR]   location: variable riskAnalysisService of type com.example.demo.service.RiskAnalysisService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/RiskThresholdController.java:[30,36] cannot find symbol
[ERROR]   symbol:   method updateThreshold(java.lang.Long,com.example.demo.model.RiskThreshold)
[ERROR]   location: variable riskThresholdService of type com.example.demo.service.RiskThresholdService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/UserPortfolioController.java:[20,32] cannot find symbol
[ERROR]   symbol:   method updatePortfolio(java.lang.Long,com.example.demo.model.UserPortfolio)
[ERROR]   location: variable portfolioService of type com.example.demo.service.UserPortfolioService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/UserPortfolioController.java:[25,25] cannot find symbol
[ERROR]   symbol:   method deactivatePortfolio(java.lang.Long)
[ERROR]   location: variable portfolioService of type com.example.demo.service.UserPortfolioService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/RiskAnalysisServiceImpl.java:[19,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/RiskThresholdServiceImpl.java:[24,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/RiskThresholdServiceImpl.java:[32,26] cannot find symbol
[ERROR]   symbol:   method findByActiveTrue()
[ERROR]   location: variable repository of type com.example.demo.repository.RiskThresholdRepository
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/UserPortfolioServiceImpl.java:[24,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/UserPortfolioServiceImpl.java:[38,26] cannot find symbol
[ERROR]   symbol:   method findByUserId(java.lang.Long)
[ERROR]   location: variable repository of type com.example.demo.repository.UserPortfolioRepository
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/UserPortfolioServiceImpl.java:[41,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/serviceimpl/UserServiceImpl.java:[24,26] cannot find symbol
[ERROR]   symbol:   method findByEmail(java.lang.String)
[ERROR]   location: variable repository of type com.example.demo.repository.UserRepository
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
public interface RiskAnalysisResultRepository extends JpaRepository<RiskAnalysisResult, Long> {
    List<RiskAnalysisResult> findByPortfolioId(Long portfolioId);  // Add custom query
}
