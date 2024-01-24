package org.dj.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import lombok.Getter;
public class Elements {

    @FindBy(xpath = "//div[contains(text(),'Weekly downloads')]") // For the text 'Weekly Downloads'
    @Getter
    private WebElement weeklyDownloadsText;

    @FindBy(xpath = "//div[contains(text(),'Weekly downloads')]/preceding-sibling::div[1]")
    @Getter
    private WebElement downloadsCount;

    @FindBy(css = "h2.text-teal-800") // CSS selector for 'Company'
    @Getter
    private WebElement companySection;

    @FindBy(css = "a[href='/about-us']") // CSS selector for 'About'
    @Getter
    private WebElement aboutLink;

    @FindBy(css = "span.bg-gradient-to-t.from-jade-400.to-teal-400.bg-clip-text.text-transparent") // CSS selector for the 'OSS' span element
    @Getter
    private WebElement OSSElement;

    @FindBy(css = "button[data-cy='header-install']") // CSS selector for the 'Install' button
    @Getter
    private WebElement installButton;

    @FindBy(css = "button[data-cy='modal-install-copy']")// CSS selector for 'npm install cypress' text
    @Getter
    private WebElement npmInstallCypressButton;

    @FindBy(xpath = "//div[contains(text(), 'NPM Install')]")// CSS selector for 'NPM Install' text
    @Getter
    private WebElement npmInstallText;

    @FindBy(css = "a[data-cy='dropdown-product']")
    @Getter
    private WebElement productButton;

    @FindBy(xpath = "//span[contains(text(), 'Visual Reviews')]")
    @Getter
    private WebElement visualReviewsButton;

    @FindBy(xpath = "//h2[contains(., 'Review and debug failures visually')]")
    @Getter
    private WebElement visualReviewsTitle;

    @FindBy(xpath = "//span[contains(text(), 'Smart Orchestration')]")
    @Getter
    private WebElement smartOrchestrationOption;

    @FindBy(xpath = "//p[contains(@class, 'mb-[8px]') and contains(@class, 'text-gray-700')]")
    @Getter
    private WebElement testAnalyticsText;

    @FindBy(css = "a[href='#test_analytics']")
    @Getter
    private WebElement testAnalyticsButton;

    @FindBy(css = "div[data-cy='screenshot-zoom']")
    @Getter
    private WebElement circleAroundTestAnalytics;

}
