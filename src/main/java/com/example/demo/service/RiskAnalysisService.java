import java.util.*;
package com.example.demo.service;
package com.example.demo.model.RiskAnalysisResult;

public interface RiskAnalysisResultService extends RiskAnalysisResult
{
   RiskAnalysisResult analyzePortfolio(Long portfoliold);
   RiskAnalysisResult getAnalysisById(Long id);
   RiskAnalysisResult getAnalysesForPortfolio(Long portfoliold);


}