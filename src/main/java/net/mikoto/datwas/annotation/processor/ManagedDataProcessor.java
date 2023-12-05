package net.mikoto.datwas.annotation.processor;

import com.google.auto.service.AutoService;
import lombok.Data;
import net.mikoto.datwas.annotation.ManagedData;
import org.jetbrains.annotations.NotNull;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author mikoto
 * &#064;date 2023/12/5
 * Create for datwas
 */
@SupportedSourceVersion(SourceVersion.RELEASE_11)
@SupportedAnnotationTypes("net.mikoto.datwas.annotation.Data")
@AutoService(Processor.class)
public class ManagedDataProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, @NotNull RoundEnvironment roundEnv) {
        roundEnv.getElementsAnnotatedWith(ManagedData.class);
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(ManagedData.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
